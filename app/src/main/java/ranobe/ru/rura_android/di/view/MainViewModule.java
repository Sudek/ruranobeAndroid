package ranobe.ru.rura_android.di.view;

import dagger.Module;
import dagger.Provides;
import ranobe.ru.rura_android.presenter.PreviewPresenter;
import ranobe.ru.rura_android.view.MainView;

@Module
public class MainViewModule {

  private MainView mainView;

  public MainViewModule(MainView mainView) {
    this.mainView = mainView;
  }

  @Provides PreviewPresenter previewPresenter() {
    return new PreviewPresenter(mainView);
  }
}
