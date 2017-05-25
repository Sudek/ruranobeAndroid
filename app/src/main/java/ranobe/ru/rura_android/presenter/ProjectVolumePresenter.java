package ranobe.ru.rura_android.presenter;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import ranobe.ru.rura_android.di.App;
import ranobe.ru.rura_android.presenter.mappers.VolumeMapper;
import ranobe.ru.rura_android.presenter.vo.Volume;
import ranobe.ru.rura_android.view.fragment.ProjectVolumeView;
import rx.Observer;
import rx.Subscription;

public class ProjectVolumePresenter extends LifecycleCallbacks {

  private static final String BUNDLE_VOLUME = "BUNDLE_VOLUME";
  private ProjectVolumeView projectVolumeView;
  private int projectId;
  private List<Volume> volumeList;

  @Inject
  VolumeMapper mapper;

  public ProjectVolumePresenter(ProjectVolumeView projectVolumeView, int projectId) {
    App.getComponent().inject(this);
    this.projectVolumeView = projectVolumeView;
    this.projectId = projectId;
  }

  public void loadVolumes() {
    Subscription subscription = mapper.volumes(mainModel, projectId).subscribe(new Observer<List<Volume>>() {
      @Override public void onCompleted() {
      }

      @Override public void onError(Throwable e) {
      }

      @Override public void onNext(List<Volume> volumes) {
        if (volumes != null && !volumes.isEmpty()) {
          volumeList = volumes;
          projectVolumeView.showVolumes(volumes);
        }
      }
    });
    addSubscription(subscription);
  }

  public void onCreate(Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      volumeList = (List<Volume>) savedInstanceState.getSerializable(BUNDLE_VOLUME);
    }
    if (volumeList == null) {
      loadVolumes();
    } else {
      projectVolumeView.showVolumes(volumeList);
    }
  }

  public void onSaveInstanceState(Bundle outState) {
    if (volumeList != null) outState.putSerializable(BUNDLE_VOLUME, new ArrayList<>(volumeList));
  }
}
