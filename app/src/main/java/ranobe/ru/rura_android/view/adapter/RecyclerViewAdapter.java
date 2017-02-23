package ranobe.ru.rura_android.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Project;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

  private List<Project> projects = new ArrayList<>();

  public void setProjects(List<Project> projects) {
    this.projects = projects;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.project_layout, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
    Project project = projects.get(position);
    holder.name.setText(project.getTitle());
  }

  @Override public int getItemCount() {
    return projects.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private TextView name;

    public ViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.textView);
    }
  }
}
