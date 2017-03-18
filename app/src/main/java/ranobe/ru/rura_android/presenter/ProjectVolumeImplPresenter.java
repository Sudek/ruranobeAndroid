package ranobe.ru.rura_android.presenter;

import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.model.data.Volume;
import ranobe.ru.rura_android.view.ProjectVolumeView;

public class ProjectVolumeImplPresenter implements ProjectVolumePresenter {

  private ProjectVolumeView pvv;

  public ProjectVolumeImplPresenter(ProjectVolumeView pvv) {
    this.pvv = pvv;
  }

  @Override public void getVolumesForScreen() {
    List<Volume> volumes = new ArrayList<>();
    Volume test = new Volume();
    test.setNameTitle("Неужели искать встречи в подземелье − неправильно? 1");
    volumes.add(0, test);
    Volume test1 = new Volume();
    test1.setNameTitle("Волчица и пряности 9: Город противостояния. Книга 2 из 2");
    volumes.add(1, test1);
    pvv.showVolumes(volumes);
  }
}
