package ranobe.ru.rura_android.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenter;
import ranobe.ru.rura_android.presenter.vo.Project;
import ranobe.ru.rura_android.view.FullImageActivity;
import ranobe.ru.rura_android.view.ProjectActivity;

public class ProjectInfoFragment extends Fragment implements ProjectInfoView {

  private final static String COVER_URL = "COVER_URL";

  @BindView(R.id.cover) ImageView cover;
  @BindView(R.id.info_title_name) TextView title;
  @BindView(R.id.info_author) TextView author;
  @BindView(R.id.info_status) TextView status;
  @BindView(R.id.info_translation) TextView translationStatus;
  @BindView(R.id.info_about_project) TextView description;

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

    infoPresenter = new ProjectInfoPresenter(this, activity.getProjectId());
    infoPresenter.onCreate(savedInstanceState);

    return view;
  }

  @Override public void showProject(Project project) {
    title.setText(project.getName());
    author.setText(project.getAuthor());
    status.setText(project.getStatus());
    translationStatus.setText("Перевод " + project.getTranslationStatus());
    description.setText(Html.fromHtml(project.getDescription()));

    Glide.with(cover.getContext())
        .load("http:" + project.getUlrCover())
        .override(450, 650)
        .into(cover);

    cover.setOnClickListener(v -> {
      Intent intent = new Intent(getContext(), FullImageActivity.class);
      intent.putExtra(COVER_URL, project.getUlrCover());
      startActivity(intent);
    });
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    infoPresenter.onSaveInstanceState(outState);
  }

  @Override public void onStop() {
    super.onStop();
    infoPresenter.onStop();
  }
}
