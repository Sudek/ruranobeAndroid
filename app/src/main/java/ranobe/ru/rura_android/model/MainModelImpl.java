package ranobe.ru.rura_android.model;

import com.squareup.okhttp.ResponseBody;
import java.util.List;
import ranobe.ru.rura_android.model.api.ApiInterface;
import ranobe.ru.rura_android.model.api.ApiModule;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.model.dto.TextDTO;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import retrofit.Response;
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

  @Override public Observable<ProjectDTO> getProject(int projectId) {
    return apiInterface.getProject(projectId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<List<VolumeDTO>> getVolumes(int projectId) {
    return apiInterface.getVolumes(projectId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<List<ChapterDTO>> getChapters(int volumeId) {
    return apiInterface.getChapters(volumeId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<TextDTO> getText(int chapterId) {
    return apiInterface.getText(chapterId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<List<ImageDTO>> getIllustrations(int chapterId) {
    return apiInterface.getIllustration(chapterId)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<ImageDTO> getImage(int imageId) {
    return apiInterface.getImage(imageId)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override public Observable<Response<ResponseBody>> getVolumeEpub(String projectUrl, String volumeUrl) {
    return apiInterface.getVolumeEpub(projectUrl, volumeUrl)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
