package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenter;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenterImp;
import ranobe.ru.rura_android.view.ProjectActivity;

public class ProjectInfoFragment extends Fragment implements ProjectInfoView {

  @Bind(R.id.cover) ImageView cover;
  @Bind(R.id.info_title_name) TextView title;
  @Bind(R.id.info_author) TextView author;
  @Bind(R.id.info_status) TextView status;
  @Bind(R.id.info_translation) TextView translationStatus;
  @Bind(R.id.info_about_project) TextView description;

  private ProjectInfoPresenter infoPresenter;


  public ProjectInfoFragment() {
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.project_info_layout, container, false);
    ButterKnife.bind(this, view);

    ProjectActivity activity = (ProjectActivity) getActivity();
    title.setText(activity.getName());
    author.setText(activity.getAuthor());

    infoPresenter = new ProjectInfoPresenterImp(this, activity.getProjectId());

    return view;
  }

  @Override public void showProject(int projectId) {

  }
}
