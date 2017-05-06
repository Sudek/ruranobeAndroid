package ranobe.ru.rura_android.presenter;

import android.util.Log;
import java.io.File;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import ranobe.ru.rura_android.view.adapter.ReaderView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ReaderPresenterImpl implements ReaderPresenter {
  private ReaderView readerView;
  private String projectUrl;
  private String volumeUrl;
  private TextMapper mapper = new TextMapper();
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenterImpl(String projectUrl, String volumeUrl) {
    this.readerView = readerView;
    this.projectUrl = projectUrl;
    this.volumeUrl = volumeUrl;
  }

  @Override public void showText() {
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
            Log.d("peka", "file was download");
            Log.d("peka", "File downloaded to " + file.getAbsolutePath());
          }
        });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
