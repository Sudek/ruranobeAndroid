package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.project_chapter_list, container, false);

    // Replace 'android.R.id.list' with the 'id' of your RecyclerView
    recyclerView = (RecyclerView) view.findViewById(android.R.id.list);
    layoutManager = new LinearLayoutManager(this.getActivity());
    Log.d(TAG, "The application stopped after this");
    recyclerView.setLayoutManager(layoutManager);

    adapter = new RecyclerAdapter(getNames());
    recyclerView.setAdapter(adapter);
    return view;
    return inflater.inflate(R.layout.project_chapters_layout, container, false);
  }
}
