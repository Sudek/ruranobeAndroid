package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.view.adapter.ProjectChapterAdapter;

public class ProjectChapterFragment extends Fragment {

  private static final String TAG = "RecyclerViewFragment";

  protected RecyclerView recyclerView;
  protected ProjectChapterAdapter adapter;
  protected RecyclerView.LayoutManager layoutManager;

  public ProjectChapterFragment() {
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
    adapter = new ProjectChapterAdapter(new ArrayList<>());
    recyclerView.setAdapter(adapter);

    return view;
  }
}
