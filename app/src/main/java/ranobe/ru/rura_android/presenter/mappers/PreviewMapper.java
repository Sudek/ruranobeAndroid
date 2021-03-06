package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import javax.inject.Inject;
import ranobe.ru.rura_android.model.MainModel;
import ranobe.ru.rura_android.presenter.vo.Preview;
import rx.Observable;

public class PreviewMapper {
  @Inject
  public PreviewMapper() {
  }

  //http://stackoverflow.com/questions/40421471/concat-multiple-calls-with-retrofit-2-and-rxjava
  public Observable<List<Preview>> previews(MainModel mainModel) {
    return mainModel.getProjects()
        .flatMap(Observable::from)
        .filter(projectDTO -> projectDTO.getImageId() != null)
        .flatMap(projectDTO -> Observable.zip(Observable.just(projectDTO),
            mainModel.getImage(projectDTO.getImageId()),
            (projectDTO1, imageDTO) -> new Preview(projectDTO1.getProjectId(), projectDTO1.getUrl(),
                projectDTO1.getTitle(), projectDTO1.getAuthor(), imageDTO.getUrl(),
                projectDTO1.getLastUpdateDate())))
        .toSortedList((preview, preview2) -> Integer.compare(preview.getProjectId(),
            preview2.getProjectId()));
  }
}
