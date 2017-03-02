package ranobe.ru.rura_android.presenter;

import java.util.List;
import ranobe.ru.rura_android.model.Model;
import ranobe.ru.rura_android.model.ModelImpl;
import ranobe.ru.rura_android.model.data.Project;
import ranobe.ru.rura_android.view.MainView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ProjectPresenter implements Presenter {

  private Model model = new ModelImpl();
  private MainView view;
  private Subscription subscription = Subscriptions.empty() ;

  public ProjectPresenter(MainView view) {
    this.view = view;
  }


  @Override public void onSearchButtonClick() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = model.getProjects()
        .subscribe(new Observer<List<Project>>() {
          @Override
          public void onCompleted() {
          }

          @Override
          public void onError(Throwable e) {
            view.showError(e.getMessage());
          }

          @Override
          public void onNext(List<Project> data) {
            if (data != null && !data.isEmpty()) {
              view.showData(data);
            } else {
              view.showEmptyList();
            }
          }
        });
  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
