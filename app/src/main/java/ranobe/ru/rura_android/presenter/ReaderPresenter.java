package ranobe.ru.rura_android.presenter;

import android.os.Bundle;
import android.util.Log;
import java.io.File;
import javax.inject.Inject;
import ranobe.ru.rura_android.di.App;
import ranobe.ru.rura_android.presenter.mappers.DownloadMapper;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;
import rx.Observer;
import rx.Subscription;

public class ReaderPresenter extends LifecycleCallbacks {

  private static final String BUNDLE_READER = "BUNDLE_READER";
  private String projectUrl;
  private String volumeUrl;
  private String fileName;
  private String downloadPath;
  private ProjectVolumeAdapter adapter;

  @Inject
  DownloadMapper mapper;

  public ReaderPresenter(String projectUrl, String volumeUrl, String fileName,
      ProjectVolumeAdapter adapter) {
    App.getComponent().inject(this);
    this.adapter = adapter;
    this.projectUrl = projectUrl;
    this.fileName = fileName;
    this.volumeUrl = volumeUrl;
  }

  public void loadEpub() {
    Subscription subscription =
        mapper.volumeFileEpub(mainModel, projectUrl, volumeUrl, fileName).subscribe(new Observer<File>() {
          @Override public void onCompleted() {
          }

          @Override public void onError(Throwable e) {
          }

          @Override public void onNext(File file) {
            if (file != null) {
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
