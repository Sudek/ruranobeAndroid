package ranobe.ru.rura_android.di;

import dagger.Module;
import dagger.Provides;
import ranobe.ru.rura_android.model.api.ApiInterface;
import ranobe.ru.rura_android.model.api.ApiModule;

@Module
public class ModelModule {
  @Provides ApiInterface provideApiInterface() {
    return ApiModule.getApiInterface();
  }
}
