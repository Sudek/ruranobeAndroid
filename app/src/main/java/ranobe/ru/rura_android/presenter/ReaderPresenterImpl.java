package ranobe.ru.rura_android.presenter;

import android.util.Log;
import java.io.File;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import ranobe.ru.rura_android.view.adapter.ProjectVolumeAdapter;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ReaderPresenterImpl implements ReaderPresenter {
  private String projectUrl;
  private String volumeUrl;
  private TextMapper mapper = new TextMapper();
  private ProjectVolumeAdapter adapter;
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenterImpl(String projectUrl, String volumeUrl, ProjectVolumeAdapter adapter) {
    this.adapter = adapter;
    this.projectUrl = projectUrl;
    this.volumeUrl = volumeUrl;
  }

  @Override public void downloadEpub() {
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
            Log.d("peka", "file was download");
            Log.d("peka", "File downloaded to " + path);
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
