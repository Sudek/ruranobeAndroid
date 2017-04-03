package ranobe.ru.rura_android.presenter;

import java.util.List;
import ranobe.ru.rura_android.presenter.entities.Project;
import ranobe.ru.rura_android.presenter.mappers.ProjectMapper;
import ranobe.ru.rura_android.view.fragment.ProjectInfoView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ProjectInfoPresenterImp implements ProjectInfoPresenter {

  private ProjectInfoView projectView;
  private ProjectMapper mapper = new ProjectMapper();
  private Subscription subscription = Subscriptions.empty();

  public ProjectInfoPresenterImp(ProjectInfoView projectView) {
    this.projectView = projectView;
  }

  @Override public void showProjectInfo(int projectId) {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.projects().subscribe(new Observer<List<Project>>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(List<Project> projects) {
        if (projects != null && !projects.isEmpty()) {
          for (int x = 0; x <= projects.size(); x++) {
            if (projects.get(x).getId() == projectId) {
              projectView.showProject(projects.get(x));
            }
          }
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
