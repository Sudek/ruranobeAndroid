package ranobe.ru.rura_android.presenter;

import java.util.List;
import ranobe.ru.rura_android.presenter.entities.Volume;
import ranobe.ru.rura_android.presenter.mappers.VolumeMapper;
import ranobe.ru.rura_android.view.fragment.ProjectVolumeView;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ProjectVolumeImplPresenter implements ProjectVolumePresenter {

  private ProjectVolumeView projectVolumeView;
  private int projectId;
  private VolumeMapper mapper = new VolumeMapper();
  private Subscription subscription = Subscriptions.empty();

  public ProjectVolumeImplPresenter(ProjectVolumeView projectVolumeView, int projectId) {
    this.projectVolumeView = projectVolumeView;
    this.projectId = projectId;
  }

  @Override public void showVolumes() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }

    subscription = mapper.volumes(projectId)
        .subscribe(new Observer<List<Volume>>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(List<Volume> volumes) {
            if (volumes != null && !volumes.isEmpty()) {
              projectVolumeView.showVolumes(volumes);
            }
          }
        });
  }

  @Override public void showChapters() {

  }

  @Override public void onStop() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }
}
