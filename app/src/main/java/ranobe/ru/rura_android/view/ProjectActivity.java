package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.view.adapter.ProjectPagerAdapter;
import ranobe.ru.rura_android.view.fragment.ProjectInfoFragment;
import ranobe.ru.rura_android.view.fragment.ProjectVolumeFragment;

public class ProjectActivity extends AppCompatActivity {

  private final static String PROJECT_ID = "PROJECT_ID";
  private int projectId;


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_tab_layout);

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);

    Bundle bundle = getIntent().getExtras();
    projectId = bundle.getInt(PROJECT_ID);
  }

  private void setupViewPager(ViewPager viewPager) {
    ProjectPagerAdapter adapter = new ProjectPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ProjectInfoFragment(), "ОПИСАНИЕ");
    adapter.addFragment(new ProjectVolumeFragment(), "ТОМА");
    viewPager.setAdapter(adapter);
  }

  public int getProjectId() {
    return projectId;
  }
}
