package ranobe.ru.rura_android.presenter;

public interface Presenter {

  void showPreviews();

  void showFilteredPreview(String userRequest);

  void onStop();
}
