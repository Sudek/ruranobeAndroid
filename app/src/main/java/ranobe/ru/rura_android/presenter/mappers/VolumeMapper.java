package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import java.util.Objects;
import ranobe.ru.rura_android.model.MainModelImpl;
import ranobe.ru.rura_android.presenter.entities.Volume;
import rx.Observable;

public class VolumeMapper {

  private MainModelImpl mainModel = new MainModelImpl();

  public Observable<List<Volume>> volumes(int projectId) {
    return mainModel.getVolumes(projectId)
        .flatMap(Observable::from)
        .filter(volumeDTO -> volumeDTO.getImageOne() != null) //delete corrupted values
        .filter(volumeDTO -> volumeDTO.getNameRu() != null) //delete untranslated values
        .filter(volumeDTO -> Objects.equals(volumeDTO.getVolumeType(), "Ранобэ")) //Now support only ranobe
        .map(volumeDTO -> new Volume(volumeDTO.getProjectId(), volumeDTO.getVolumeId(),
            volumeDTO.getSequenceNumber(), volumeDTO.getNameTitle(), volumeDTO.getImageOne(),
            volumeDTO.getVolumeType(), volumeDTO.getVolumeType(), volumeDTO.getNameRu()))
        .toSortedList((volume, volume2) -> Float.compare(volume.getIndex(), volume2.getIndex()));
  }
}
