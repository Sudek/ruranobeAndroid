package ranobe.ru.rura_android.presenter;

import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.presenter.entities.Preview;
import ranobe.ru.rura_android.presenter.mappers.PreviewMapper;
import ranobe.ru.rura_android.view.MainView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class PreviewPresenter implements Presenter {

  private MainView view;
  private Subscription subscription = Subscriptions.empty() ;
  private PreviewMapper previewMapper = new PreviewMapper();
  private List<Preview> previews = new ArrayList<>();

  public PreviewPresenter(MainView view) {
    this.view = view;
  }


  @Override public void showPreviews() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = previewMapper.previews()
        .subscribe(new Observer<List<Preview>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            view.showError(e.getMessage());
          }

          @Override public void onNext(List<Preview> data) {
            if (data != null && !data.isEmpty()) {
              view.showData(data);
              previews = data;
            } else {
              view.showEmptyList();
            }
          }
        });
  }

  @Override public void showFilteredPreview(String userRequest) {
    ArrayList<Preview> result = new ArrayList<>();
    String lowerCaseQuery = userRequest.toLowerCase();
    for (int i = 0; i < previews.size(); i++) {
      String name = previews.get(i).getProjectName().toLowerCase();
      if (name.contains(lowerCaseQuery)) {
        result.add(previews.get(i));
      }
    }
    view.showData(result);
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
