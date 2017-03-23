package ranobe.ru.rura_android.presenter.mappers;

import android.util.Log;
import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.presenter.entities.Preview;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public class PreviewMapper {

  private MainModelImpl mainModel = new MainModelImpl();
  private Preview preview;
  //http://stackoverflow.com/questions/40421471/concat-multiple-calls-with-retrofit-2-and-rxjava
  public Observable<List<ProjectDTO>> previews() {
    Log.d("peka", "tut1");
    return mainModel.getProjects()
        .flatMap(new Func1<List<ProjectDTO>, Observable<ProjectDTO>>() {
          @Override
          public Observable<ProjectDTO> call(List<ProjectDTO> projects) {
            Log.d("peka", "tut2");
            return Observable.from(projects);
          }
        }).flatMap(new Func1<ProjectDTO, Observable<ProjectDTO>>() {
      @Override
      public Observable<ProjectDTO> call(ProjectDTO project) {
        Log.d("peka", "tut3");
        return Observable.zip(Observable.just(project),
            mainModel.getImage(project.getImageId()),
            new Func2<ProjectDTO, ImageDTO, ProjectDTO>() {
              @Override
              public ProjectDTO call(ProjectDTO project, ImageDTO image) {
                project.setUrl(image.getUrl());
                Log.d("peka", image.getUrl());
                return project;
              }
            });
      }
    }).toList();
  }
}
