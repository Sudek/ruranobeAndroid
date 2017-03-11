package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Project;
import ranobe.ru.rura_android.presenter.Presenter;
import ranobe.ru.rura_android.presenter.ProjectPresenter;
import ranobe.ru.rura_android.view.adapter.MainViewAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

  private Presenter presenter;
  private MainViewAdapter adapter;
  private static final String TAG = "MainActivity";


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    presenter = new ProjectPresenter(this);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(llm);
    adapter = new MainViewAdapter();
    recyclerView.setAdapter(adapter);

    presenter.onSearchButtonClick();
  }

  @Override public void showData(List<Project> projects) {
    adapter.setProjects(projects);
  }

  @Override public void showError(String error) {
  }

  @Override public void showEmptyList() {
    Log.d(TAG, "emptyList");
  }
}
