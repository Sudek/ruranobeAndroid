package ranobe.ru.rura_android.model.api;

import java.util.List;
import ranobe.ru.rura_android.model.data.Project;
import retrofit.http.GET;
import rx.Observable;

public interface ApiInterface {

  @GET("projects")
  Observable<List<Project>> getProjects();

}
