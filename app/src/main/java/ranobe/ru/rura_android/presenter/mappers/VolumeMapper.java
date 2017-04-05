package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.presenter.entities.Volume;
import rx.Observable;

public class VolumeMapper {

  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<List<Volume>> volumes(int projectId) {
    return mainModel.getVolumes(projectId)
        .flatMap(Observable::from)
        .map(volumeDTO -> new Volume(volumeDTO.getProjectId(), volumeDTO.getVolumeId(),
            volumeDTO.getSequenceNumber(), volumeDTO.getNameTitle(), volumeDTO.getImageOne()))
        .toSortedList((volume, volume2) -> Integer.compare(volume.getIndex(), volume2.getIndex()));
  }
}
