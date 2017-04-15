package ranobe.ru.rura_android.model;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.model.dto.TextDTO;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import rx.Observable;

public interface MainModel {

  Observable<List<ProjectDTO>> getProjects();

  Observable<ProjectDTO> getProject(int projectId);

  Observable<List<VolumeDTO>> getVolumes(int projectId);

  Observable<List<ChapterDTO>> getChapters(int volumeId);

  Observable<TextDTO> getText(int chapterId);

  Observable<List<ImageDTO>> getIllustrations(int chapterId);

  Observable<ImageDTO> getImage(int imageId);
}
