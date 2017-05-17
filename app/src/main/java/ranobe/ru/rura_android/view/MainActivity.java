package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.PreviewPresenter;
import ranobe.ru.rura_android.presenter.PreviewPreviewPresenterImpl;
import ranobe.ru.rura_android.presenter.vo.Preview;
import ranobe.ru.rura_android.view.adapter.MainViewAdapter;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, MainView {

  private static final String TAG = "MainActivity";
  private RecyclerView recyclerView;
  private PreviewPresenter previewPresenter;
  private MainViewAdapter adapter;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    previewPresenter = new PreviewPreviewPresenterImpl(this);

    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(llm);
    adapter = new MainViewAdapter();
    recyclerView.setAdapter(adapter);

    previewPresenter.showPreviews();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);

    final MenuItem searchItem = menu.findItem(R.id.action_search);
    final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
    searchView.setOnQueryTextListener(this);

    return true;
  }

  @Override public boolean onQueryTextSubmit(String s) {
    return false;
  }

  @Override public boolean onQueryTextChange(String s) {
    recyclerView.scrollToPosition(0);
    previewPresenter.showFilteredPreview(s);
    return true;
  }

  @Override public void showData(List<Preview> previews) {
    adapter.setProjects(previews);
  }

  @Override public void showError(String error) {
  }

  @Override public void showEmptyList() {
    Log.d(TAG, "emptyList");
  }
}
