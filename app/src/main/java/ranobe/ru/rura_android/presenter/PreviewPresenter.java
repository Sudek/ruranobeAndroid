package ranobe.ru.rura_android.presenter;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.presenter.mappers.PreviewMapper;
import ranobe.ru.rura_android.view.MainView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class PreviewPresenter implements Presenter {

  private MainView view;
  private Subscription subscription = Subscriptions.empty() ;
  private PreviewMapper previewMapper = new PreviewMapper();

  public PreviewPresenter(MainView view) {
    this.view = view;
  }


  @Override public void onSearchButtonClick() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = previewMapper.previews()
        .subscribe(new Observer<List<ProjectDTO>>() {
          @Override
          public void onCompleted() {
          }

          @Override
          public void onError(Throwable e) {
            view.showError(e.getMessage());
          }

          @Override
          public void onNext(List<ProjectDTO> data) {
            if (data != null && !data.isEmpty()) {
              view.showData(data);
            } else {
              view.showEmptyList();
            }
          }
        });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
