package ranobe.ru.rura_android.presenter;

import ranobe.ru.rura_android.presenter.entities.Text;
import ranobe.ru.rura_android.presenter.mappers.TextMapper;
import ranobe.ru.rura_android.view.ReaderView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ReaderPresenterImpl implements ReaderPresenter {
  private ReaderView readerView;
  private int chapterId;
  private TextMapper mapper = new TextMapper();
  private Subscription subscription = Subscriptions.empty();

  public ReaderPresenterImpl(ReaderView readerView, int chapterId) {
    this.readerView = readerView;
    this.chapterId = chapterId;
  }

  @Override public void showText() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.text(chapterId)
        .subscribe(new Observer<Text>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(Text text) {
            readerView.showData(text);
          }
        });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
