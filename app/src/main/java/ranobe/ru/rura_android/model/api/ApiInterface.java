package ranobe.ru.rura_android.model.api;

import java.util.List;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface ApiInterface {

  @GET("projects")
  Observable<List<ProjectDTO>> getProjects();

  @GET("projects/{projectId}")
  Observable<ProjectDTO> getProject(@Path("projectId") int ProjectId);

  @GET("projects/{projectId}/volumes")
  Observable<List<VolumeDTO>> getVolumes(@Path("projectId") int projectId);

  @GET("volumes/{volumeId}/chapters")
  Observable<List<ChapterDTO>> getChapters(@Path("volumieId") int volumeId);

  @GET("images/{imageId}")
  Observable<ImageDTO> getImage(@Path("imageId") int imageId);
}
