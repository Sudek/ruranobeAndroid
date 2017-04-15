package ranobe.ru.rura_android.presenter.mappers;

import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import ranobe.ru.rura_android.presenter.entities.Project;
import rx.Observable;
import rx.functions.Func1;

public class ProjectMapper {

  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<Project> projects(int projectId) {
    return mainModel.getVolumes(projectId)
        .flatMap(Observable::from)
        .filter(volumeDTO -> volumeDTO.getImageOne() != null)
        .filter(volumeDTO -> volumeDTO.getSequenceNumber() == 1)
        .flatMap(new Func1<VolumeDTO, Observable<Project>>() {
          @Override public Observable<Project> call(VolumeDTO volumeDTO) {
            return Observable.zip(Observable.just(volumeDTO),
                mainModel.getImage(volumeDTO.getImageOne()), mainModel.getProject(projectId),
                (volumeDTO1, imageDTO, projectDTO) -> new Project(projectDTO.getProjectId(),
                    projectDTO.getTitle(), projectDTO.getAuthor(), projectDTO.getStatus(),
                    projectDTO.getTranslationStatus(), projectDTO.getAnnotationParsed(),
                    imageDTO.getUrl()));
          }
        });
  }
}