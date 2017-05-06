package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenter;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenterImpl;
import ranobe.ru.rura_android.presenter.entities.Project;
import ranobe.ru.rura_android.view.ProjectActivity;

public class ProjectInfoFragment extends Fragment implements ProjectInfoView {

  @Bind(R.id.cover) ImageView cover;
  @Bind(R.id.info_title_name) TextView title;
  @Bind(R.id.info_author) TextView author;
  @Bind(R.id.info_status) TextView status;
  @Bind(R.id.info_translation) TextView translationStatus;
  @Bind(R.id.info_about_project) TextView description;

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

    ProjectInfoPresenter infoPresenter = new ProjectInfoPresenterImpl(this, activity.getProjectId());
    infoPresenter.showProjectInfo();

    return view;
  }

  @Override public void showProject(Project project) {
    title.setText(project.getName());
    author.setText(project.getAuthor());
    status.setText(project.getStatus());
    translationStatus.setText("Перевод " + project.getTranslationStatus());
    description.setText(Html.fromHtml(project.getDescription()));
    Picasso.with(cover.getContext())
        .load("http:" + project.getUlrCover())
        .resize(450, 650)
        .into(cover);
  }
}
