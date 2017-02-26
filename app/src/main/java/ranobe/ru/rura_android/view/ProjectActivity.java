package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.view.adapter.ProjectPagerAdapter;

public class ProjectActivity extends AppCompatActivity implements ProjectView {

  private TabLayout tabLayout;
  private ViewPager viewPager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.project_layout);

    viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
  }

  private void setupViewPager(ViewPager viewPager) {
    ProjectPagerAdapter adapter = new ProjectPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ProjectFragment(), "INFO");
    adapter.addFragment(new ProjectFragment(), "CHAPTERS");
    viewPager.setAdapter(adapter);
  }
}
