package ranobe.ru.rura_android.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Volume;

public class ProjectVolumeAdapter extends RecyclerView.Adapter<ProjectVolumeAdapter.ViewHolder> {

  private static final String TAG = "ProjectVolumeAdapter";
  private List<Volume> volumes = new ArrayList<>();

  public void setVolumes(List<Volume> volumes) {
    this.volumes = volumes;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.chapter_element_layout, parent, false);

    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Volume volume = volumes.get(position);
    holder.volumeName.setText(volume.getNameTitle());
  }

  @Override public int getItemCount() {
    return volumes.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private TextView volumeName;

    public ViewHolder(View v) {
      super(v);
      volumeName = (TextView) v.findViewById(R.id.info_title_name);
      v.setOnClickListener(v1 -> Log.d(TAG, "Element " + getAdapterPosition() + " clicked."));
    }
  }
}