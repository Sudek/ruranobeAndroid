package ranobe.ru.rura_android.presenter.entities;

import java.io.Serializable;

public class Chapter implements Serializable {
  private int chapterId;
  private String chapterName;

  public Chapter(int chapterId, String chapterName) {
    this.chapterId = chapterId;
    this.chapterName = chapterName;
  }

  public int getChapterId() {
    return chapterId;
  }

  public void setChapterId(int chapterId) {
    this.chapterId = chapterId;
  }

  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }
}
