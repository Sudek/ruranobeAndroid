package ranobe.ru.rura_android.presenter.mappers;

import android.os.Environment;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import okio.BufferedSink;
import okio.Okio;
import ranobe.ru.rura_android.model.MainModelImpl;
import retrofit.Response;
import rx.Observable;
import rx.functions.Func1;

public class DownloadMapper {
  //http://www.codexpedia.com/android/android-download-large-file-using-retrofit-streaming/
  public Observable<File> volumeFileEpub(MainModelImpl mainModel, String projectUrl,
      String volumeUrl, String fileName) {
    return mainModel.getVolumeEpub(projectUrl, volumeUrl)
        .flatMap(new Func1<Response<ResponseBody>, Observable<File>>() {
          @Override public Observable<File> call(Response<ResponseBody> responseBodyResponse) {
            return Observable.create(subscriber -> {
              try {
                File folder = new File(
                    Environment.getExternalStorageDirectory() + File.separator + "Ruranobe");
                if (!folder.exists()) {
                  folder.mkdirs();
                }
                File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Ruranobe"
                    , fileName);
                BufferedSink sink = Okio.buffer(Okio.sink(file));
                sink.writeAll(responseBodyResponse.body().source());
                sink.close();
                subscriber.onNext(file);
                subscriber.onCompleted();
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
          }
        });
  }
}
