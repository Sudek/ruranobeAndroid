package ranobe.ru.rura_android.model;

import java.util.List;
import ranobe.ru.rura_android.model.api.ApiInterface;
import ranobe.ru.rura_android.model.api.ApiModule;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainModelImpl implements MainModel {

  private ApiInterface apiInterface = ApiModule.getApiInterface();

  @Override public Observable<List<ProjectDTO>> getProjects() {
    return apiInterface.getProjects()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<List<VolumeDTO>> getVolumes(int projectId) {
    return null;
  }

  @Override public Observable<List<ChapterDTO>> getChapters(int volumeId) {
    return null;
  }

  @Override public Observable<ImageDTO> getImage(int imageId) {
    return apiInterface.getImage(imageId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
