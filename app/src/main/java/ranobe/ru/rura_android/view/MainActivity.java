package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import butterknife.ButterKnife;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Project;
import ranobe.ru.rura_android.presenter.Presenter;
import ranobe.ru.rura_android.presenter.ProjectPresenter;
import ranobe.ru.rura_android.view.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements View {

  private Presenter presenter;
  private RecyclerViewAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
    ButterKnife.bind(this);

    presenter = new ProjectPresenter(this);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    Button button = (Button) findViewById(R.id.button);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(llm);
    adapter = new RecyclerViewAdapter();
    recyclerView.setAdapter(adapter);

    button.setOnClickListener(v -> {
      presenter.onSearchButtonClick();
      Log.d("Peka", "click");
    });
  }

  @Override public void showData(List<Project> projects) {
    adapter.setProjects(projects);
  }

  @Override public void showError(String error) {

  }

  @Override public void showEmptyList() {
    Log.d("Peka", "emptyList");
  }
}
