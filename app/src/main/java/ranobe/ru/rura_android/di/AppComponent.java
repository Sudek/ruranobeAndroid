package ranobe.ru.rura_android.di;

import dagger.Component;
import javax.inject.Singleton;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.presenter.LifecycleCallbacks;
import ranobe.ru.rura_android.presenter.PreviewPresenter;
import ranobe.ru.rura_android.presenter.ProjectInfoPresenter;
import ranobe.ru.rura_android.presenter.ProjectVolumePresenter;
import ranobe.ru.rura_android.presenter.ReaderPresenter;

@Singleton @Component(modules = { ModelModule.class, PresenterModule.class})
public interface AppComponent {
  void inject(MainModelImpl data);

  void inject(LifecycleCallbacks callbacks);

  void inject(PreviewPresenter previewPresenter);

  void inject(ProjectInfoPresenter projectInfoPresenter);

  void inject(ProjectVolumePresenter projectVolumePresenter);

  void inject(ReaderPresenter readerPresenter);
}
