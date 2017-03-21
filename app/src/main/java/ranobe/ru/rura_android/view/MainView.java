package ranobe.ru.rura_android.view;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ProjectDTO;

public interface MainView {

  void showData(List<ProjectDTO> projects);

  void showError(String error);

  void showEmptyList();
}
