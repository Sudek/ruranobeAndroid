package ranobe.ru.rura_android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.chrisbanes.photoview.PhotoView;
import ranobe.ru.rura_android.R;

public class FullImageActivity extends AppCompatActivity {

  private final static String COVER_URL = "COVER_URL";

  @BindView(R.id.full_screen_image) PhotoView fullCover;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.full_screen_cover_layout);

    ButterKnife.bind(this);

    String coverUrl = getIntent().getStringExtra(COVER_URL);

    Glide.with(FullImageActivity.this)
        .load("http:" + coverUrl)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(fullCover);
  }
}
