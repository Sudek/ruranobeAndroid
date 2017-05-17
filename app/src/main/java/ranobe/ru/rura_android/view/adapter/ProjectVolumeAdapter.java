package ranobe.ru.rura_android.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.folioreader.activity.FolioActivity;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ReaderPresenter;
import ranobe.ru.rura_android.presenter.ReaderPresenterImpl;
import ranobe.ru.rura_android.presenter.entities.Volume;

public class ProjectVolumeAdapter extends RecyclerView.Adapter<ProjectVolumeAdapter.ViewHolder>
    implements ReaderView {

  private List<Volume> volumes = new ArrayList<>();
  private Context context;
  private String projectUrl;

  public void setData(List<Volume> volumes, String projectUrl) {
    this.volumes = volumes;
    this.projectUrl = projectUrl;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.chapter_element_layout, parent, false);
    context = parent.getContext();

    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Volume volume = volumes.get(position);
    holder.volumeName.setText(volume.getNameRu());

    //storage/emulated/0/Download/Tate_no_Yuusha_no_Nariagari_01.epub
    holder.itemView.setOnClickListener(view -> {
      ReaderPresenter presenter = new ReaderPresenterImpl(projectUrl, volume.getUrl(), this);
      presenter.downloadEpub();
      Toast.makeText(context, "Файл начал скачиваться", Toast.LENGTH_LONG).show();
    });
  }

  @Override public int getItemCount() {
    return volumes.size();
  }

  @Override public void startFolio(String path) {
    Intent intent = new Intent(context, FolioActivity.class);
    intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, FolioActivity.EpubSourceType.SD_CARD);
    intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, path);
    context.startActivity(intent);
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private TextView volumeName;

    ViewHolder(View v) {
      super(v);
      volumeName = (TextView) v.findViewById(R.id.info_title_name);
    }
  }
}
