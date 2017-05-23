package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.vo.Epub;
import ranobe.ru.rura_android.view.adapter.DownloadedAdapter;

public class DownloadedActivity extends AppCompatActivity implements DownloadedView {

  private DownloadedAdapter adapter;
  private RecyclerView recyclerView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.project_volume_list);

    recyclerView = (RecyclerView) findViewById(R.id.recyclerViewChapters);
    recyclerView.setHasFixedSize(true);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(llm);
    adapter = new DownloadedAdapter();
    showDownloadedEpubs();
    recyclerView.setAdapter(adapter);
  }

  @Override public void showDownloadedEpubs() {
    List<Epub> epubs = new ArrayList<>();
    String path = Environment.getExternalStorageDirectory() + File.separator + "Ruranobe";
    File directory = new File(path);
    File[] files = directory.listFiles();
    for (File file : files) {
      epubs.add(new Epub(file.getName(), file.getAbsolutePath()));
    }
    adapter.setPaths(epubs);
  }
}