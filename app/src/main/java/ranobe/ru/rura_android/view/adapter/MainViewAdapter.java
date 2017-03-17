package ranobe.ru.rura_android.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Project;
import ranobe.ru.rura_android.view.ProjectActivity;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder> {

  private List<Project> projects = new ArrayList<>();
  private static final String TAG = "RecyclerViewAdapter";


  public void setProjects(List<Project> projects) {
    this.projects = projects;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.main_card_view, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(MainViewAdapter.ViewHolder holder, int position) {
    Project project = projects.get(position);
    holder.name.setText(project.getTitle());
    holder.author.setText(project.getAuthor());
    holder.itemView.setOnClickListener(view -> {
      view.getContext().startActivity(new Intent(view.getContext(), ProjectActivity.class));
      Log.d(TAG, "onclick " + position);
    });
  }

  @Override public int getItemCount() {
    return projects.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView author;

    public ViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.projectName);
      author = (TextView) itemView.findViewById(R.id.authorName);
    }
  }
}
