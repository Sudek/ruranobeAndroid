package ranobe.ru.rura_android.presenter.mappers;

import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.presenter.entities.Text;
import rx.Observable;
import rx.functions.Func1;

public class TextMapper {
  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<List<Text>> text(int volumeId) {
    return mainModel.getChapters(volumeId)
        .flatMap(Observable::from)
        .flatMap(new Func1<ChapterDTO, Observable<Text>>() {
          @Override public Observable<Text> call(ChapterDTO chapterDTO) {
            return Observable.zip(Observable.just(chapterDTO),
                mainModel.getText(chapterDTO.getChapterId()),
                mainModel.getIllustrations(chapterDTO.getChapterId()),
                (chapterDTO1, textDTO, imageDTOs) -> {
                  int size = imageDTOs.size();
                  List<String> imageUrl = new ArrayList<>();
                  if (0 < size) {
                    for (int x = 0; x < size; x++) {
                      imageUrl.add(imageDTOs.get(x).getUrl());
                    }
                  }
                  return new Text(textDTO.getTextId(), chapterDTO1.getOrderNumber(),
                      textDTO.getTextHtml(), textDTO.getContents(), textDTO.getFootnotes(),
                      imageUrl);
                });
          }
        })
        .toSortedList(
            (text, text2) -> Integer.compare(text.getOrderNumber(), text2.getOrderNumber()));
  }
}
