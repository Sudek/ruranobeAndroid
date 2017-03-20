package ranobe.ru.rura_android.model;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import rx.Observable;

public interface MainModel {

  Observable<List<ProjectDTO>> getProjects();

  Observable<List<VolumeDTO>> getVolumes(int projectId);

  Observable<List<ChapterDTO>> getChapters(int volumeId);

  Observable<ImageDTO> getImage(int imageId);
}
