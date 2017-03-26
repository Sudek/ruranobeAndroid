package ranobe.ru.rura_android.view.fragment;

import ranobe.ru.rura_android.presenter.entities.Project;

public interface ProjectInfoView {

  void showProjectInfo(Project project);

  void showError(String error);
}
