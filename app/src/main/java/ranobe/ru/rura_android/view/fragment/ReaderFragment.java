package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import ranobe.ru.rura_android.R;

public class ReaderFragment extends Fragment {
  @Bind(R.id.reader_text) TextView textView;
  private String text;
  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.text_layout, container, false);
    ButterKnife.bind(this, viewGroup);
    textView.setText(Html.fromHtml(text));
    return viewGroup;
  }

  public void setText(String text) {
    this.text = text;
  }
}
