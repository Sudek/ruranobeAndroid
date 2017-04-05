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
import ranobe.ru.rura_android.presenter.ProjectVolumeImplPresenter;
import ranobe.ru.rura_android.presenter.ProjectVolumePresenter;
import ranobe.ru.rura_android.presenter.entities.Volume;
import ranobe.ru.rura_android.view.ProjectActivity;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;

public class ProjectVolumeFragment extends Fragment implements ProjectVolumeView {

  private static final String TAG = "ProjectVolumeFragment";

  private ProjectVolumeAdapter adapter;

  public ProjectVolumeFragment() {
    //https://developer.android.com/samples/RecyclerView/src/com.example.android.recyclerview/RecyclerViewFragment.html
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.project_chapter_list, container, false);

    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewChapters);
    recyclerView.setHasFixedSize(true);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
    recyclerView.setLayoutManager(layoutManager);
    adapter = new ProjectVolumeAdapter();
    recyclerView.setAdapter(adapter);

    ProjectActivity activity = (ProjectActivity) getActivity();
    ProjectVolumePresenter presenter = new ProjectVolumeImplPresenter(this, activity.getProjectId());
    presenter.showVolumes();

    return view;
  }

  @Override public void showVolumes(List<Volume> volumes) {
    adapter.setVolume(volumes);
  }
}
