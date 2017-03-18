package ranobe.ru.rura_android.view;

import java.util.List;
import ranobe.ru.rura_android.model.data.Project;

public interface MainView {

  void showData(List<Project> projects);

  void showError(String error);

  void showEmptyList();
}
