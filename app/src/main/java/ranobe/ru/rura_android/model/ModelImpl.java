package ranobe.ru.rura_android.model;

import java.util.List;
import ranobe.ru.rura_android.model.api.ApiInterface;
import ranobe.ru.rura_android.model.api.ApiModule;
import ranobe.ru.rura_android.model.data.Image;
import ranobe.ru.rura_android.model.data.Project;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ModelImpl implements Model {

  private ApiInterface apiInterface = ApiModule.getApiInterface();

  @Override public Observable<List<Project>> getProjects() {
    return apiInterface.getProjects()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<Image> getImage(int imageId) {
    return apiInterface.getImage(imageId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
