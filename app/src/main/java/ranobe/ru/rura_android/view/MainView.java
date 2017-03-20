package ranobe.ru.rura_android.view;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ProjectDTO;

public interface MainView {

  void showData(List<ProjectDTO> projectDTOs);

  void showError(String error);

  void showEmptyList();
}
