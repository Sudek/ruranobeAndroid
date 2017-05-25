package ranobe.ru.rura_android.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;
import javax.inject.Inject;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.di.view.DaggerViewComponent;
import ranobe.ru.rura_android.di.view.MainViewModule;
import ranobe.ru.rura_android.di.view.ViewComponent;
import ranobe.ru.rura_android.presenter.PreviewPresenter;
import ranobe.ru.rura_android.presenter.vo.Preview;
import ranobe.ru.rura_android.view.adapter.MainViewAdapter;

public class MainActivity extends AppCompatActivity
    implements SearchView.OnQueryTextListener, MainView {

  @Inject
  PreviewPresenter previewPresenter;

  private ViewComponent viewComponent;
  private RecyclerView recyclerView;
  private MainViewAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    if (viewComponent == null) {
      viewComponent = DaggerViewComponent.builder().mainViewModule(new MainViewModule(this)).build();
    }
    viewComponent.inject(this);

    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(llm);
    adapter = new MainViewAdapter();
    recyclerView.setAdapter(adapter);

    previewPresenter.onCreate(savedInstanceState);
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

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if(item.getItemId() == R.id.download)
    {
      Intent intent = new Intent(this, DownloadedActivity.class);
      startActivity(intent);
    }
    return true;
  }

  @Override public void showPreview(List<Preview> previews) {
    adapter.setProjects(previews);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    previewPresenter.onSaveInstanceState(outState);
  }

  @Override protected void onStop() {
    super.onStop();
    if (previewPresenter != null) {
      previewPresenter.onStop();
    }
  }
}
