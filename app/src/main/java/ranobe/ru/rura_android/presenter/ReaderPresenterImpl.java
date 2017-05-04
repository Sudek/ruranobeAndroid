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
  private int volumeId;
  private TextMapper mapper = new TextMapper();
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenterImpl(int volumeId) {
    this.readerView = readerView;
    this.volumeId = volumeId;
  }

  @Override public void showText() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.text(volumeId)
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
