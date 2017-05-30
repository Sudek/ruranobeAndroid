package ranobe.ru.rura_android.di;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import ranobe.ru.rura_android.model.api.ApiInterface;
import ranobe.ru.rura_android.model.api.ApiModule;

@Module public class ModelModule {
  @Singleton @Provides ApiInterface provideApiInterface() {
    return ApiModule.getApiInterface();
  }
}
