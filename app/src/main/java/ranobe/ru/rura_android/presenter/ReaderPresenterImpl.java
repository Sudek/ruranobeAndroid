package ranobe.ru.rura_android.presenter;

import java.io.File;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ReaderPresenterImpl implements ReaderPresenter {
  private String projectUrl;
  private String volumeUrl;
  private TextMapper mapper = new TextMapper();
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenterImpl(String projectUrl, String volumeUrl) {

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

          }
        });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
