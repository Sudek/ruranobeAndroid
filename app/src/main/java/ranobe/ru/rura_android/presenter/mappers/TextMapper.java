package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.TextDTO;
import ranobe.ru.rura_android.presenter.entities.Text;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public class TextMapper {
  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<List<Text>> text(int volumeId) {
    return mainModel.getChapters(volumeId)
        .flatMap(Observable::from)
        .flatMap(new Func1<ChapterDTO, Observable<Text>>() {
          @Override public Observable<Text> call(ChapterDTO chapterDTO) {
            return Observable.zip(Observable.just(chapterDTO),
                mainModel.getText(chapterDTO.getChapterId()),
                new Func2<ChapterDTO, TextDTO, Text>() {
                  @Override public Text call(ChapterDTO chapterDTO, TextDTO textDTO) {
                    return new Text(textDTO.getTextId(), chapterDTO.getOrderNumber(),
                        textDTO.getTextHtml(), textDTO.getContents(), textDTO.getFootnotes());
                  }
                });
          }
        })
        .toSortedList(
            (text, text2) -> Integer.compare(text.getOrderNumber(), text2.getOrderNumber()));
  }
}
