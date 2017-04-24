package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ReaderPresenter;
import ranobe.ru.rura_android.presenter.ReaderPresenterImpl;
import ranobe.ru.rura_android.presenter.entities.Text;
import ranobe.ru.rura_android.view.fragment.ReaderFragment;

public class ReaderActivity extends FragmentActivity implements ReaderView{
//https://developer.android.com/training/animation/screen-slide.html
//http://stackoverflow.com/questions/23853585/how-can-i-change-the-fragments-content-on-slide-in-viewpager
//http://stackoverflow.com/questions/10431945/how-to-get-n-text-that-can-be-fit-on-screen-textview-with-a-specific-size
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

    Bundle bundle = getIntent().getExtras();
    volumeId = bundle.getInt(VOLUME_ID);

    ReaderPresenter presenter = new ReaderPresenterImpl(this, volumeId);
    presenter.showText();

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
    ArrayList<String> text = new ArrayList<>();
    public ScreenSlidePagerAdapter(FragmentManager fm, List<Text> texts) {
      super(fm);
      for (int x = 0; x < texts.size(); x++) {
        text.add(texts.get(x).getTextHtml());
      }
    }

    @Override public Fragment getItem(int position) {
      ReaderFragment fragment = new ReaderFragment();
      fragment.setText(text.get(position));
      return fragment;
    }

    @Override public int getCount() {
      return 3;
    }
  }
  @Override public void showData(List<Text> text) {
    //webView.loadData(text.get(1).getTextHtml(), "text/html; charset=utf-8", "UTF-8");
    //webView.loadUrl("http://ruranobe.ru/r/ddmmd/v1/p");
    // Instantiate a ViewPager and a PagerAdapter.
    mPager = (ViewPager) findViewById(R.id.pager);
    mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), text);
    mPager.setAdapter(mPagerAdapter);
  }

  @Override public void showError(String error) {

  }
}
