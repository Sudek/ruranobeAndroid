package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import javax.inject.Inject;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.presenter.vo.Chapter;
import rx.Observable;

public class ChapterMapper {
  @Inject public ChapterMapper() {
  }

  public Observable<List<Chapter>> chapters(MainModelImpl mainModel, int volumeId) {
    return mainModel.getChapters(volumeId)
        .flatMap(Observable::from)
        .map(chapterDTO -> new Chapter(chapterDTO.getChapterId(), chapterDTO.getOrderNumber(),
            chapterDTO.getTitle()))
        .toList();
  }
}
