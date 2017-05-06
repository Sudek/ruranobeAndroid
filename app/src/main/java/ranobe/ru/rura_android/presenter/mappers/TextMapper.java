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

public class TextMapper {
  private MainModelImpl mainModel = new MainModelImpl();
//http://www.codexpedia.com/android/android-download-large-file-using-retrofit-streaming/
  public Observable<File> volumeFileEpub(String projectUrl, String volumeUrl) {
    return mainModel.getVolumeEpub(projectUrl, volumeUrl)
        .flatMap(new Func1<Response<ResponseBody>, Observable<File>>() {
          @Override public Observable<File> call(Response<ResponseBody> responseBodyResponse) {
            return Observable.create(subscriber -> {
              try {
                // you can access headers of response
                String header = responseBodyResponse.headers().get("Content-Disposition");
                // this is specific case, it's up to you how you want to save your file
                // if you are not downloading file from direct link, you might be lucky to obtain file name from header
                //String fileName = header.replace("attachment; filename*=UTF-8", "");
                String fileName = header.substring(29);

                // will create file in global Music directory, can be any other directory, just don't forget to handle permissions
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .getAbsoluteFile(), fileName);

                BufferedSink sink = Okio.buffer(Okio.sink(file));
                // you can access body of response
                sink.writeAll(responseBodyResponse.body().source());
                sink.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
          }
        });
  }
}
