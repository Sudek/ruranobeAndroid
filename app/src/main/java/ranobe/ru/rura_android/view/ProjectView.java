package ranobe.ru.rura_android.view;

import ranobe.ru.rura_android.presenter.entities.Project;

public interface ProjectView {
  void showProject(Project project);

  void showError(String error);

  void showEmptyList();
}
