package ranobe.ru.rura_android.presenter;

import javax.inject.Inject;
import ranobe.ru.rura_android.di.App;
import ranobe.ru.rura_android.model.MainModel;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class LifecycleCallbacks {

  @Inject
  protected MainModel mainModel;

  @Inject
  CompositeSubscription compositeSubscription;

  public LifecycleCallbacks() {
    App.getComponent().inject(this);
  }

  public void addSubscription(Subscription subscription) {
    compositeSubscription.add(subscription);
  }

  public void onStop() {
    compositeSubscription.clear();
  }
}
