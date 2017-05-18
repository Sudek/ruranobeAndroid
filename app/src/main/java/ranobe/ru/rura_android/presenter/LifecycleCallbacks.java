package ranobe.ru.rura_android.presenter;

import ranobe.ru.rura_android.model.MainModelImpl;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class LifecycleCallbacks {
  protected MainModelImpl dataRepository = new MainModelImpl();
  private CompositeSubscription compositeSubscription = new CompositeSubscription();

  protected void addSubscription(Subscription subscription) {
    compositeSubscription.add(subscription);
  }

  public void onStop() {
    compositeSubscription.clear();
  }
}
