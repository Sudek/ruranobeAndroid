package ranobe.ru.rura_android.presenter;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.presenter.mappers.PreviewMapper;
import ranobe.ru.rura_android.presenter.vo.Preview;
import ranobe.ru.rura_android.view.MainView;
import rx.Observer;
import rx.Subscription;

public class PreviewPresenter extends LifecycleCallbacks {

  private static final String BUNDLE_PREVIEWS = "BUNDLE_PREVIEWS";
  private MainView view;
  private PreviewMapper previewMapper = new PreviewMapper();
  private List<Preview> previews;

  public PreviewPresenter(MainView view) {
    this.view = view;
  }

  public void loadPreviews() {
    Subscription subscription = previewMapper.previews(dataRepository).subscribe(new Observer<List<Preview>>() {
      @Override public void onCompleted() {
      }

      @Override public void onError(Throwable e) {
      }

      @Override public void onNext(List<Preview> data) {
        if (data != null && !data.isEmpty()) {
          view.showPreview(data);
          previews = data;
        }
      }
    });
    addSubscription(subscription);
  }

  public void showFilteredPreview(String userRequest) {
    ArrayList<Preview> result = new ArrayList<>();
    String lowerCaseQuery = userRequest.toLowerCase();
    for (int i = 0; i < previews.size(); i++) {
      String name = previews.get(i).getProjectName().toLowerCase();
      if (name.contains(lowerCaseQuery)) {
        result.add(previews.get(i));
      }
    }
    view.showPreview(result);
  }

  public void onCreate(Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      previews = (List<Preview>) savedInstanceState.getSerializable(BUNDLE_PREVIEWS);
    }
    if (previews == null) {
      loadPreviews();
    } else {
      view.showPreview(previews);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (previews != null) {
      outState.putSerializable(BUNDLE_PREVIEWS, new ArrayList<>(previews));
    }
  }
}
