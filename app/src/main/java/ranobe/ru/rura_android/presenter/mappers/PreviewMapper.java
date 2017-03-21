package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.presenter.entities.Preview;
import rx.Observable;

public class PreviewMapper {

  private MainModelImpl model = new MainModelImpl();
  //http://stackoverflow.com/questions/40421471/concat-multiple-calls-with-retrofit-2-and-rxjava
  public Observable<List<Preview>> previews(List<ProjectDTO> projectDTOs) {
    return Observable.from(projectDTOs)
        .map(projectDTO -> new Preview(projectDTO.getTitle(), projectDTO.getAuthor(), projectDTO.getUrl()))
        //.flatMap(projectDTO -> model.getImage(projectDTO.getImageId()))
        .toList();
  }
}
