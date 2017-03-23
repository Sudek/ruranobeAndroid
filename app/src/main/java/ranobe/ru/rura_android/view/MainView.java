package ranobe.ru.rura_android.view;

import java.util.List;
import ranobe.ru.rura_android.presenter.entities.Preview;

public interface MainView {

  void showData(List<Preview> previews);

  void showError(String error);

  void showEmptyList();
}
