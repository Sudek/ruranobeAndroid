package ranobe.ru.rura_android.presenter.entities;

import java.io.Serializable;

public class Preview implements Serializable {
  private int projectId;
  private String projectName;
  private String author;
  private String urlBanner;

  public Preview(int projectId, String projectName, String author, String urlBanner) {
    this.projectId = projectId;
    this.projectName = projectName;
    this.author = author;
    this.urlBanner = urlBanner;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    projectId = projectId;
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
