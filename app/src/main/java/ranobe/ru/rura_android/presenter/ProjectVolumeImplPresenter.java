package ranobe.ru.rura_android.presenter;

import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import ranobe.ru.rura_android.view.ProjectVolumeView;

public class ProjectVolumeImplPresenter implements ProjectVolumePresenter {

  private ProjectVolumeView pvv;

  public ProjectVolumeImplPresenter(ProjectVolumeView pvv) {
    this.pvv = pvv;
  }

  @Override public void getVolumesForScreen() {
    List<VolumeDTO> volumeDTOs = new ArrayList<>();
    VolumeDTO test = new VolumeDTO();
    test.setNameTitle("Неужели искать встречи в подземелье − неправильно? 1");
    volumeDTOs.add(0, test);
    VolumeDTO test1 = new VolumeDTO();
    test1.setNameTitle("Волчица и пряности 9: Город противостояния. Книга 2 из 2");
    volumeDTOs.add(1, test1);
    pvv.showVolumes(volumeDTOs);
  }
}
