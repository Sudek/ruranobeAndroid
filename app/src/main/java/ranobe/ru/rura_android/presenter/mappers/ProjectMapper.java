package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.presenter.entities.Project;
import rx.Observable;

public class ProjectMapper {
  public Observable<List<Project>> previews(List<ProjectDTO> projectDTOs) {
    return Observable.from(projectDTOs)
        .map(projectDTO -> new Project(projectDTO.getTitle(), projectDTO.getAuthor(),
            projectDTO.getStatus(), projectDTO.getTranslationStatus(), projectDTO.getAnnotation()))
        .toList();
  }
}
