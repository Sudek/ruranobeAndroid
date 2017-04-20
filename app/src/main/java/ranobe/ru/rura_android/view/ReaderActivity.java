package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import butterknife.Bind;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.entities.Text;
import ranobe.ru.rura_android.view.adapter.ReaderPagerAdapter;
import ranobe.ru.rura_android.view.fragment.ReaderFragment;

public class ReaderActivity extends AppCompatActivity implements ReaderView {

  private final static String VOLUME_ID = "VOLUME_ID";
  private int volumeId;

  @Bind(R.id.web_view) WebView webView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tab_layout);

    Bundle bundle = getIntent().getExtras();
    volumeId = bundle.getInt(VOLUME_ID);

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    //TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
    //tabLayout.setupWithViewPager(viewPager);
  }

  @Override public void showData(List<Text> text) {
    //webView.loadData(text.get(1).getTextHtml(), "text/html; charset=utf-8", "UTF-8");
    //webView.loadUrl("http://ruranobe.ru/r/ddmmd/v1/p");
  }

  @Override public void showError(String error) {

  }

  private void setupViewPager(ViewPager viewPager) {
    ReaderPagerAdapter adapter = new ReaderPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ReaderFragment(), "1");
    adapter.addFragment(new ReaderFragment(), "2");
    adapter.addFragment(new ReaderFragment(), "3");
    viewPager.setCurrentItem(1);
    viewPager.setAdapter(adapter);
  }

  public int getVolumeId() {
    return volumeId;
  }
}
