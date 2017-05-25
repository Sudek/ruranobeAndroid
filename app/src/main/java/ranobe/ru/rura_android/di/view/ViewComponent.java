package ranobe.ru.rura_android.di.view;

import dagger.Component;
import javax.inject.Singleton;
import ranobe.ru.rura_android.view.MainActivity;

@Singleton
@Component(modules = {MainViewModule.class})
public interface ViewComponent {
  void inject(MainActivity mainActivity);
}
