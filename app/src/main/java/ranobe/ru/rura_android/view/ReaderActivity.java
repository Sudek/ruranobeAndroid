package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.entities.Text;
import ranobe.ru.rura_android.view.fragment.ReaderFragment;

public class ReaderActivity extends FragmentActivity implements ReaderView {

  private final static String VOLUME_ID = "VOLUME_ID";
  private int volumeId;

  private ViewPager mPager;

  /**
   * The pager adapter, which provides the pages to the view pager widget.
   */
  private PagerAdapter mPagerAdapter;


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pager);

    // Instantiate a ViewPager and a PagerAdapter.
    mPager = (ViewPager) findViewById(R.id.pager);
    mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
    mPager.setAdapter(mPagerAdapter);

  }

  @Override public void onBackPressed() {
    if (mPager.getCurrentItem() == 0) {
      // If the user is currently looking at the first step, allow the system to handle the
      // Back button. This calls finish() on this activity and pops the back stack.
      super.onBackPressed();
    } else {
      // Otherwise, select the previous step.
      mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }
  }

  private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return new ReaderFragment();
    }

    @Override
    public int getCount() {
      return 5;
    }
  }
  @Override public void showData(List<Text> text) {
    //webView.loadData(text.get(1).getTextHtml(), "text/html; charset=utf-8", "UTF-8");
    //webView.loadUrl("http://ruranobe.ru/r/ddmmd/v1/p");
  }

  @Override public void showError(String error) {

  }
}
