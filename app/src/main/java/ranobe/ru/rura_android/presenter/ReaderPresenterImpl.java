package ranobe.ru.rura_android.presenter;

import java.util.List;
import ranobe.ru.rura_android.presenter.entities.Text;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import ranobe.ru.rura_android.view.ReaderView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ReaderPresenterImpl implements ReaderPresenter {
  private ReaderView readerView;
  private int volumeId;
  private TextMapper mapper = new TextMapper();
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenterImpl(ReaderView readerView, int volumeId) {
    this.readerView = readerView;
    this.volumeId = volumeId;
  }

  @Override public void showText() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.text(volumeId)
        .subscribe(new Observer<List<Text>>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(List<Text> texts) {
        readerView.showData(texts);
      }
    });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
