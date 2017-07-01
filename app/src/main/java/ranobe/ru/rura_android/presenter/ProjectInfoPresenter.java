package ranobe.ru.rura_android.presenter;

import android.os.Bundle;
import javax.inject.Inject;
import ranobe.ru.rura_android.di.App;
import ranobe.ru.rura_android.presenter.mappers.ProjectMapper;
import ranobe.ru.rura_android.presenter.vo.Project;
import ranobe.ru.rura_android.view.fragment.ProjectInfoView;
import rx.Observer;
import rx.Subscription;

public class ProjectInfoPresenter extends LifecycleCallbacks {

  private static final String BUNDLE_PROJECT = "BUNDLE_PROJECT";
  private ProjectInfoView projectView;
  private Project savedProject;
  private int projectId;

  @Inject ProjectMapper mapper;

  public ProjectInfoPresenter(ProjectInfoView projectView, int projectId) {
    App.getComponent().inject(this);
    this.projectView = projectView;
    this.projectId = projectId;
  }

  public void loadProjectInfo() {
    Subscription subscription =
        mapper.projects(mainModel, projectId).subscribe(new Observer<Project>() {

          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(Project project) {
            savedProject = project;
            projectView.showProject(project);
          }
        });
    addSubscription(subscription);
  }

  public void onCreate(Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      savedProject = (Project) savedInstanceState.getSerializable(BUNDLE_PROJECT);
    }
    if (savedProject == null) {
      loadProjectInfo();
    } else {
      projectView.showProject(savedProject);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (savedProject != null) {
      outState.putSerializable(BUNDLE_PROJECT, savedProject);
    }
  }
}
