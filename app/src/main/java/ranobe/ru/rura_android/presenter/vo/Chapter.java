package ranobe.ru.rura_android.presenter.vo;

import java.io.Serializable;

public class Chapter implements Serializable {
  private int chapterId;
  private int orderNumber;
  private String chapterName;

  public Chapter(int chapterId, int orderNumber, String chapterName) {
    this.chapterId = chapterId;
    this.orderNumber = orderNumber;
    this.chapterName = chapterName;
  }

  public int getChapterId() {
    return chapterId;
  }

  public void setChapterId(int chapterId) {
    this.chapterId = chapterId;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }
}
