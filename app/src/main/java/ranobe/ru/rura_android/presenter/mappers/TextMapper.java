package ranobe.ru.rura_android.presenter.mappers;

import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.presenter.entities.Text;
import rx.Observable;

public class TextMapper {
  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<Text> text(int chapterId) {
    return mainModel.getText(chapterId)
        .map(textDTO -> new Text(textDTO.getTextId(), textDTO.getTextHtml(), textDTO.getContents(),
            textDTO.getFootnotes()));
  }
}
