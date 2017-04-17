package ranobe.ru.rura_android.presenter.mappers;

    import java.util.List;
    import ranobe.ru.rura_android.model.MainModelImpl;
    import ranobe.ru.rura_android.presenter.entities.Chapter;
    import rx.Observable;

public class ChapterMapper {
  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<List<Chapter>> chapters(int volumeId) {
    return mainModel.getChapters(volumeId)
        .flatMap(Observable::from)
        .map(chapterDTO -> new Chapter(chapterDTO.getChapterId(), chapterDTO.getOrderNumber(),
            chapterDTO.getTitle()))
        .toList();
  }
}
