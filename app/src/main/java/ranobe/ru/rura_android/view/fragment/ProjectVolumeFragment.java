package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ProjectVolumePresenter;
import ranobe.ru.rura_android.presenter.vo.Volume;
import ranobe.ru.rura_android.view.ProjectActivity;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;

public class ProjectVolumeFragment extends Fragment implements ProjectVolumeView {

  private ProjectVolumeAdapter adapter;
  private ProjectVolumePresenter volumePresenter;
  private String projectUrl;

  public ProjectVolumeFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.list_layout, container, false);

    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewVolumes);
    recyclerView.setHasFixedSize(true);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
    recyclerView.setLayoutManager(layoutManager);
    adapter = new ProjectVolumeAdapter();
    recyclerView.setAdapter(adapter);

    ProjectActivity activity = (ProjectActivity) getActivity();
    projectUrl = activity.getProjectUrl();
    volumePresenter = new ProjectVolumePresenter(this, activity.getProjectId());
    volumePresenter.onCreate(savedInstanceState);

    return view;
  }

  @Override public void showVolumes(List<Volume> volumes) {
    adapter.setData(volumes, projectUrl);
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    volumePresenter.onSaveInstanceState(outState);
  }

  @Override public void onStop() {
    super.onStop();
    volumePresenter.onStop();
  }
}
