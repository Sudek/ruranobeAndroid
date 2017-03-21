package ranobe.ru.rura_android.presenter.entities;

import java.io.Serializable;

public class Preview implements Serializable {
  private String projectName;
  private String author;
  private String urlBanner;

  public Preview(String projectName, String author, String urlBanner) {
    this.projectName = projectName;
    this.author = author;
    this.urlBanner = urlBanner;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getUrlBanner() {
    return urlBanner;
  }

  public void setUrlBanner(String urlBanner) {
    this.urlBanner = urlBanner;
  }
}
