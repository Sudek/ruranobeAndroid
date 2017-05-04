package ranobe.ru.rura_android.view.adapter;

import java.util.List;
import ranobe.ru.rura_android.presenter.entities.Text;

public interface ReaderView {
  void showData(List<Text> texts);

  void showError(String error);
}
