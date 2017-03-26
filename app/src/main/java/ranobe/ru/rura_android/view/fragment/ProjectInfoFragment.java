package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.entities.Project;

public class ProjectInfoFragment extends Fragment implements ProjectInfoView {
  public ProjectInfoFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.project_info_layout, container, false);
  }

  @Override public void showProjectInfo(Project project) {

  }

  @Override public void showError(String error) {

  }
}
