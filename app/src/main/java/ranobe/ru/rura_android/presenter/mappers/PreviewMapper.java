package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.presenter.entities.Preview;
import rx.Observable;
import rx.functions.Func1;

public class PreviewMapper {

  private MainModelImpl mainModel = new MainModelImpl();

  //http://stackoverflow.com/questions/40421471/concat-multiple-calls-with-retrofit-2-and-rxjava
  public Observable<List<Preview>> previews() {
    return mainModel.getProjects().flatMap(new Func1<List<ProjectDTO>, Observable<ProjectDTO>>() {
      @Override public Observable<ProjectDTO> call(List<ProjectDTO> projects) {
        return Observable.from(projects);
      }
    }).flatMap(new Func1<ProjectDTO, Observable<Preview>>() {
      @Override public Observable<Preview> call(ProjectDTO projectDTO) {
        if (projectDTO.getImageId() == null) {
          projectDTO.setImageId(11208); //if imageId is null, zip don't work
        }
        return Observable.zip(Observable.just(projectDTO),
            mainModel.getImage(projectDTO.getImageId()),
            (projectDTO1, imageDTO) -> new Preview(projectDTO1.getTitle(), projectDTO1.getAuthor(),
                imageDTO.getUrl()));
      }
    }).toList();
  }
}
