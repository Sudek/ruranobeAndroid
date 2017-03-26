package ranobe.ru.rura_android.presenter;

import ranobe.ru.rura_android.presenter.mappers.ProjectMapper;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ProjectInfoPresenterImp implements ProjectInfoPresenter {
  private ProjectMapper mapper;
  private Subscription subscription = Subscriptions.empty() ;

  @Override public void showProjectInfo() {

  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
