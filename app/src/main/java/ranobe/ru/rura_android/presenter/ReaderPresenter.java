package ranobe.ru.rura_android.presenter;

import android.os.Bundle;
import android.util.Log;
import java.io.File;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;
import rx.Observer;
import rx.Subscription;

public class ReaderPresenter extends LifecycleCallbacks {

  private static final String BUNDLE_READER = "BUNDLE_READER";
  private String projectUrl;
  private String volumeUrl;
  private String fileName;
  private String downloadPath;
  private TextMapper mapper = new TextMapper();
  private ProjectVolumeAdapter adapter;

  public ReaderPresenter(String projectUrl, String volumeUrl, String fileName,
      ProjectVolumeAdapter adapter) {
    this.adapter = adapter;
    this.projectUrl = projectUrl;
    this.fileName = fileName;
    this.volumeUrl = volumeUrl;
  }

  public void loadEpub() {
    Subscription subscription =
        mapper.volumeFileEpub(dataRepository, projectUrl, volumeUrl, fileName).subscribe(new Observer<File>() {
          @Override public void onCompleted() {
          }

          @Override public void onError(Throwable e) {
          }

          @Override public void onNext(File file) {
            if (file != null && downloadPath != null) {
              String path = file.getAbsolutePath();
              Log.d("rura", "file was download");
              Log.d("rura", "File downloaded to " + path);
              downloadPath = path;
              adapter.startFolio(path);
            }
          }
        });
    addSubscription(subscription);
  }

  public void onCreate(Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      downloadPath = (String) savedInstanceState.getSerializable(BUNDLE_READER);
    }
    if (downloadPath == null) {
      loadEpub();
    } else {
      adapter.startFolio(downloadPath);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (downloadPath != null) outState.putSerializable(BUNDLE_READER, downloadPath);
  }
}
