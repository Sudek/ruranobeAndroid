package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.ReaderPresenter;
import ranobe.ru.rura_android.presenter.ReaderPresenterImpl;
import ranobe.ru.rura_android.presenter.entities.Text;

public class ReaderActivity extends AppCompatActivity implements ReaderView {

  private final static String VOLUME_ID = "VOLUME_ID";
  private int volumeId;
  @Bind(R.id.web_view) WebView webView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.text_layout);
    ButterKnife.bind(this);

    Bundle bundle = getIntent().getExtras();
    volumeId = bundle.getInt(VOLUME_ID);

    ReaderPresenter readerPresenter = new ReaderPresenterImpl(this, volumeId);
    readerPresenter.showText();
  }

  @Override public void showData(List<Text> text) {
    webView.loadData(text.get(1).getTextHtml(), "text/html; charset=utf-8", "UTF-8");
    //webView.loadUrl("http://ruranobe.ru/r/ddmmd/v1/p");
  }

  @Override public void showError(String error) {

  }
}
