package ranobe.ru.rura_android.view;

import ranobe.ru.rura_android.presenter.entities.Text;

public interface ReaderView {
  void showData(Text text);

  void showError(String error);
}
