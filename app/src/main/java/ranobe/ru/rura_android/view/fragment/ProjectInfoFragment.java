package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import io.realm.Realm;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenter;
import ranobe.ru.rura_android.presenter.vo.Project;
import ranobe.ru.rura_android.view.ProjectActivity;

public class ProjectInfoFragment extends Fragment implements ProjectInfoView {

  @BindView(R.id.cover) ImageView cover;
  @BindView(R.id.info_title_name) TextView title;
  @BindView(R.id.info_author) TextView author;
  @BindView(R.id.info_status) TextView status;
  @BindView(R.id.info_translation) TextView translationStatus;
  @BindView(R.id.info_about_project) TextView description;

  private ProjectInfoPresenter infoPresenter;
  private Realm realm;

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
    realm.init(getContext());
    realm = Realm.getDefaultInstance();

    if (readFromRealm(activity.getProjectId()) == null) {
      infoPresenter = new ProjectInfoPresenter(this, activity.getProjectId());
      writeToRealm(new Project(1, null, null, null, null, null, null, null));
      infoPresenter.onCreate(savedInstanceState);
    }
    else {
      showProject(readFromRealm(1));
    }
    realm.close();
    return view;
  }

  @Override public void showProject(Project project) {
    title.setText(project.getName());
    author.setText(project.getAuthor());
    status.setText(project.getStatus());
    translationStatus.setText("Перевод " + project.getTranslationStatus());
    description.setText("kek");
    Glide.with(cover.getContext())
        .load("http:" + project.getUlrCover())
        .override(450, 650)
        .into(cover);
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    infoPresenter.onSaveInstanceState(outState);
  }

  @Override public void onStop() {
    super.onStop();
    infoPresenter.onStop();
  }
  //
  //private Project getCashedPreviews() {
  //  return findInRealm(realm, projectId);
  //}

  private Project readFromRealm(int projectId) {
    return findInRealm(realm, projectId);
  }

  private Project writeToRealm(Project projectResponse) {
    realm.executeTransaction(transactionRealm -> {
      Project project = findInRealm(transactionRealm, projectResponse.getProjectId());
      if (project == null) {
        project = transactionRealm.createObject(Project.class, 1);
      }
    });
    realm.close();
    return projectResponse;
  }

  private Project findInRealm(Realm realm, int projectId) {
    return realm.where(Project.class).equalTo("projectId", projectId).findFirst();
  }
}
