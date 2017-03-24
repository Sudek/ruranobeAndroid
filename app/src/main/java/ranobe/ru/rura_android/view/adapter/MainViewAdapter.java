package ranobe.ru.rura_android.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.entities.Preview;
import ranobe.ru.rura_android.view.ProjectActivity;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder> {

  private List<Preview> previews = new ArrayList<>();
  private static final String TAG = "RecyclerViewAdapter";

  public void setProjectDTOs(List<Preview> previews) {
    this.previews = previews;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.main_card_view, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(MainViewAdapter.ViewHolder holder, int position) {
    Preview preview = previews.get(position);
    holder.name.setText(preview.getProjectName());
    holder.author.setText(preview.getAuthor());
    Picasso.with(holder.banner.getContext()).load("http:" + preview.getUrlBanner()).resize(400, 125)
        .into(holder.banner);
    holder.itemView.setOnClickListener(view -> view.getContext().startActivity(new Intent(view.getContext(), ProjectActivity.class)));
  }

  @Override public int getItemCount() {
    return previews.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView author;
    private ImageView banner;

    ViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.projectName);
      author = (TextView) itemView.findViewById(R.id.authorName);
      banner = (ImageView) itemView.findViewById(R.id.banner);
    }
  }
}
