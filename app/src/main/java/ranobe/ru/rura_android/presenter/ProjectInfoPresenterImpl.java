package ranobe.ru.rura_android.presenter;

import ranobe.ru.rura_android.presenter.vo.Project;
import ranobe.ru.rura_android.presenter.mappers.ProjectMapper;
import ranobe.ru.rura_android.view.fragment.ProjectInfoView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ProjectInfoPresenterImpl implements ProjectInfoPresenter {

  private ProjectInfoView projectView;
  private ProjectMapper mapper = new ProjectMapper();
  private Subscription subscription = Subscriptions.empty();
  private int projectId;

  public ProjectInfoPresenterImpl(ProjectInfoView projectView, int projectId) {
    this.projectView = projectView;
    this.projectId = projectId;
  }

  @Override public void showProjectInfo() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.projects(projectId)
        .subscribe(new Observer<Project>() {

      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(Project project) {
        projectView.showProject(project);
      }
    });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
