package ranobe.ru.rura_android.presenter;

import ranobe.ru.rura_android.presenter.mappers.ProjectMapper;
import ranobe.ru.rura_android.view.fragment.ProjectInfoView;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ProjectInfoPresenterImp implements ProjectInfoPresenter {

  private ProjectInfoView projectView;
  private int projectId;
  private ProjectMapper mapper;
  private Subscription subscription = Subscriptions.empty() ;

  public ProjectInfoPresenterImp(ProjectInfoView projectView, int projectId) {
    this.projectView = projectView;
    this.projectId = projectId;
  }

  @Override public void showProjectInfo(int projectId) {

  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
