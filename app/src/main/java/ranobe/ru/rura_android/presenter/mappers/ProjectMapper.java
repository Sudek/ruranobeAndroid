package ranobe.ru.rura_android.presenter.mappers;

import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.presenter.entities.Project;
import rx.Observable;

public class ProjectMapper {

  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<Project> projects(int projectId) {
    return mainModel.getProject(projectId)
        .map(projectDTO -> new Project(projectDTO.getProjectId(), projectDTO.getTitle(),
            projectDTO.getAuthor(), projectDTO.getStatus(), projectDTO.getTranslationStatus(),
            projectDTO.getAnnotation()));
  }
}
