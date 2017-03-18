package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Volume;
import ranobe.ru.rura_android.presenter.ProjectVolumeImplPresenter;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;

public class ProjectVolumeFragment extends Fragment implements ProjectVolumeView {

  private static final String TAG = "ProjectVolumeFragment";

  private RecyclerView recyclerView;
  private ProjectVolumeAdapter adapter;
  private RecyclerView.LayoutManager layoutManager;
  private ProjectVolumeImplPresenter pvip;

  public ProjectVolumeFragment() {
    // Required empty public constructor
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

    recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewChapters);
    recyclerView.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(this.getActivity());
    recyclerView.setLayoutManager(layoutManager);
    adapter = new ProjectVolumeAdapter();
    recyclerView.setAdapter(adapter);

    //pvip.getVolumesForScreen();
    List<Volume> asd = new ArrayList<>();
    showVolumes(asd);

    return view;
  }

  @Override public void showVolumes(List<Volume> volumes) {
    Volume test = new Volume();
    test.setNameTitle("Неужели искать встречи в подземелье − неправильно? 1");
    volumes.add(0, test);
    Log.d(TAG, String.valueOf(volumes.get(0)));
    Volume test1 = new Volume();
    test1.setNameTitle("Волчица и пряности 9: Город противостояния. Книга 2 из 2");
    volumes.add(1, test1);
    Log.d(TAG, String.valueOf(volumes.get(1)));
    adapter.setVolumes(volumes);
  }
}