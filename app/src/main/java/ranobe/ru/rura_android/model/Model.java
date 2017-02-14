package ranobe.ru.rura_android.model;

import java.util.List;
import ranobe.ru.rura_android.model.data.Project;
import rx.Observable;

public interface Model {
  Observable<List<Project>> getProjects();
}
