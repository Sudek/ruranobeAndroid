package ranobe.ru.rura_android.model.api;

import com.squareup.okhttp.ResponseBody;
import java.util.List;
import ranobe.ru.rura_android.model.dto.ChapterDTO;
import ranobe.ru.rura_android.model.dto.ImageDTO;
import ranobe.ru.rura_android.model.dto.ProjectDTO;
import ranobe.ru.rura_android.model.dto.TextDTO;
import ranobe.ru.rura_android.model.dto.VolumeDTO;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Streaming;
import rx.Observable;

public interface ApiInterface {

  @GET("projects")
  Observable<List<ProjectDTO>> getProjects();

  @GET("projects/{projectId}")
  Observable<ProjectDTO> getProject(@Path("projectId") int ProjectId);

  @GET("projects/{projectId}/volumes")
  Observable<List<VolumeDTO>> getVolumes(@Path("projectId") int projectId);

  @GET("volumes/{volumeId}/chapters")
  Observable<List<ChapterDTO>> getChapters(@Path("volumeId") int volumeId);

  @GET("chapters/{chapterId}/text")
  Observable<TextDTO> getText(@Path("chapterId") int chapterId);

  @GET("chapters/{chapterId}/illustration")
  Observable<List<ImageDTO>> getIllustration(@Path("chapterId") int chapterId);

  @GET("images/{imageId}")
  Observable<ImageDTO> getImage(@Path("imageId") int imageId);

  @Streaming
  @GET("http://ruranobe.ru/d/epub/{projectUrl}/{volumeUrl}")
  Observable<Response<ResponseBody>> getVolumeEpub(@Path("projectUrl") String projectUrl,
      @Path("volumeUrl") String volumeUrl);
}
