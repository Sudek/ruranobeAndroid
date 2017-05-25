package ranobe.ru.rura_android.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import ranobe.ru.rura_android.model.MainModel;
import ranobe.ru.rura_android.model.MainModelImpl;
import rx.subscriptions.CompositeSubscription;

@Module public class PresenterModule {
  @Provides @Singleton MainModel provideData() {
    return new MainModelImpl();
  }

  @Provides CompositeSubscription provideCompositeSubscription() {
    return new CompositeSubscription();
  }
}
