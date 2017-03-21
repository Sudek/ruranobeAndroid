package ranobe.ru.rura_android.presenter.entities;

import java.io.Serializable;

public class Project implements Serializable {
  private String name;
  private String author;
  private String status;
  private String translationStatus;
  private String description;
  private String ulrCover;

  public Project(String name, String author, String status, String translationStatus,
      String description) {
    this.name = name;
    this.author = author;
    this.status = status;
    this.translationStatus = translationStatus;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTranslationStatus() {
    return translationStatus;
  }

  public void setTranslationStatus(String translationStatus) {
    this.translationStatus = translationStatus;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUlrCover() {
    return ulrCover;
  }

  public void setUlrCover(String ulrCover) {
    this.ulrCover = ulrCover;
  }
}
