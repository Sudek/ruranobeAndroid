package ranobe.ru.rura_android.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.folioreader.activity.FolioActivity;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.vo.Epub;

public class DownloadedAdapter extends RecyclerView.Adapter<DownloadedAdapter.ViewHolder> {

  private Context context;
  private List<Epub> epubs = new ArrayList<>();

  public void setPaths(List<Epub> epubs) {
    this.epubs = epubs;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.element_list_layout, parent, false);
    context = parent.getContext();
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Epub epub = epubs.get(position);
    holder.name.setText(epub.getName());

    holder.itemView.setOnClickListener(v -> {
      Intent intent = new Intent(context, FolioActivity.class);
      intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, FolioActivity.EpubSourceType.SD_CARD);
      intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, epub.getPath());
      context.startActivity(intent);
    });
  }

  @Override public int getItemCount() {
    return epubs.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private TextView name;

    ViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.info_title_name);
    }
  }
}
