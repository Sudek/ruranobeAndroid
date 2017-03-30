package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.entities.Project;
import ranobe.ru.rura_android.view.adapter.ProjectPagerAdapter;
import ranobe.ru.rura_android.view.fragment.ProjectInfoFragment;
import ranobe.ru.rura_android.view.fragment.ProjectVolumeFragment;

public class ProjectActivity extends AppCompatActivity implements ProjectView {

  private static final String BUNDLE_PROJECT_KEY = "POSITION";

  private List<Project> projects = new ArrayList<>();
  private int projectPosition;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_tab_layout);

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);

    Bundle bundle = getIntent().getExtras();
    projectPosition = bundle.getInt(BUNDLE_PROJECT_KEY);
  }

  private void setupViewPager(ViewPager viewPager) {
    ProjectPagerAdapter adapter = new ProjectPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ProjectInfoFragment(), "ОПИСАНИЕ");
    adapter.addFragment(new ProjectVolumeFragment(), "ТОМА");
    viewPager.setAdapter(adapter);
  }

  public Project getProject(int x) {
    return projects.get(x);
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  @Override public void showProject(Project project) {

  }

  @Override public void showError(String error) {

  }

  @Override public void showEmptyList() {

  }
}
