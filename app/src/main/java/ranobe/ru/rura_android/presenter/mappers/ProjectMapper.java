package ranobe.ru.rura_android.presenter.mappers;

import javax.inject.Inject;
import ranobe.ru.rura_android.model.MainModel;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import ranobe.ru.rura_android.presenter.vo.Project;
import rx.Observable;
import rx.functions.Func1;

public class ProjectMapper {
  @Inject
  public ProjectMapper() {
  }

  public Observable<Project> projects(MainModel mainModel, int projectId) {
    return mainModel.getVolumes(projectId)
        .flatMap(Observable::from)
        .filter(volumeDTO -> volumeDTO.getImageOne() != null)
        .filter(volumeDTO -> volumeDTO.getSequenceNumber() == 1)
        .first()
        .flatMap(new Func1<VolumeDTO, Observable<Project>>() {
          @Override public Observable<Project> call(VolumeDTO volumeDTO) {
            return Observable.zip(Observable.just(volumeDTO),
                mainModel.getImage(volumeDTO.getImageOne()), mainModel.getProject(projectId),
                (volumeDTO1, imageDTO, projectDTO) -> new Project(projectDTO.getProjectId(),
                    projectDTO.getTitle(), projectDTO.getAuthor(), projectDTO.getStatus(),
                    projectDTO.getTranslationStatus(), projectDTO.getAnnotationParsed(),
                    imageDTO.getUrl(), projectDTO.getLastUpdateDate()));
          }
        });
  }
}