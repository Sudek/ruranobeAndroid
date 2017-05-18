package ranobe.ru.rura_android.presenter;

import android.util.Log;
import java.io.File;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ReaderPresenter extends LifecycleCallbacks{
  private String projectUrl;
  private String volumeUrl;
  private TextMapper mapper = new TextMapper();
  private ProjectVolumeAdapter adapter;
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenter(String projectUrl, String volumeUrl, ProjectVolumeAdapter adapter) {
    this.adapter = adapter;
    this.projectUrl = projectUrl;
    this.volumeUrl = volumeUrl;
  }

  public void downloadEpub() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.volumeFileEpub(projectUrl, volumeUrl)
        .subscribe(new Observer<File>() {
          @Override public void onCompleted() {
          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(File file) {
            String path = file.getAbsolutePath();
            Log.d("rura", "file was download");
            Log.d("rura", "File downloaded to " + path);
            adapter.startFolio(path);
          }
        });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
