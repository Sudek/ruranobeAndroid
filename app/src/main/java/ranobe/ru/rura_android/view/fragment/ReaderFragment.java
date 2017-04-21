package ranobe.ru.rura_android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ranobe.ru.rura_android.R;

public class ReaderFragment extends Fragment {
  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.text_layout, container, false);

    return viewGroup;
  }
}
