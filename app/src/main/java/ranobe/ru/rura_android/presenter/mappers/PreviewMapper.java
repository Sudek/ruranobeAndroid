package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.presenter.entities.Preview;
import rx.Observable;
import rx.functions.Func1;

public class PreviewMapper {

  private MainModelImpl mainModel = new MainModelImpl();
  private Preview preview;
  //http://stackoverflow.com/questions/40421471/concat-multiple-calls-with-retrofit-2-and-rxjava
  public Observable<List<ProjectDTO>> previews() {
    return mainModel.getProjects()
        .flatMap(new Func1<List<ProjectDTO>, Observable<ProjectDTO>>() {
          @Override
          public Observable<ProjectDTO> call(List<ProjectDTO> projects) {
            return Observable.from(projects);
          }
        }).flatMap(new Func1<ProjectDTO, Observable<ProjectDTO>>() {
      @Override
      public Observable<ProjectDTO> call(ProjectDTO project) {
        if (project.getImageId() == null) project.setImageId(11208);
        return Observable.zip(Observable.just(project),
            mainModel.getImage(project.getImageId()), (project1, image) -> {
              project1.setUrl(image.getUrl());
              return project1;
            });
      }
    }).toList();
  }
}
