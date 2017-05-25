package ranobe.ru.rura_android.presenter.mappers;

import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import ranobe.ru.rura_android.model.MainModel;
import ranobe.ru.rura_android.presenter.vo.Volume;
import rx.Observable;

public class VolumeMapper {
  @Inject
  public VolumeMapper() {
  }

  public Observable<List<Volume>> volumes(MainModel mainModel, int projectId) {
    return mainModel.getVolumes(projectId)
        .flatMap(Observable::from)
        .filter(volumeDTO -> volumeDTO.getImageOne() != null) //delete corrupted values
        .filter(volumeDTO -> volumeDTO.getNameRu() != null) //delete untranslated values
        .filter(volumeDTO -> volumeDTO.getVolumeStatus().matches("DONE|TRANSLATING|DECOR"))
        .filter(volumeDTO -> Objects.equals(volumeDTO.getVolumeType(), "Ранобэ")) //Now support only ranobe
        .map(volumeDTO -> new Volume(volumeDTO.getProjectId(), volumeDTO.getVolumeId(),
            volumeDTO.getSequenceNumber(), volumeDTO.getNameTitle(), volumeDTO.getImageOne(),
            volumeDTO.getVolumeType(), volumeDTO.getVolumeType(), volumeDTO.getNameRu(),
            volumeDTO.getUrl(), volumeDTO.getFileName()))
        .toSortedList((volume, volume2) -> Float.compare(volume.getIndex(), volume2.getIndex()));
  }
}
