package ranobe.ru.rura_android.presenter.entities;

import java.io.Serializable;
import java.util.Date;

public class Preview implements Serializable {
  private int projectId;
  private String projectUrl;
  private String projectName;
  private String author;
  private String urlBanner;
  private Date lastUpdate;

  public Preview(int projectId, String projectUrl, String projectName, String author, String urlBanner,
      Date lastUpdate) {
    this.projectId = projectId;
    this.projectUrl = projectUrl;
    this.projectName = projectName;
    this.author = author;
    this.urlBanner = urlBanner;
    this.lastUpdate = lastUpdate;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    projectId = projectId;
  }

  public String getProjectUrl() {
    return projectUrl;
  }

  public void setProjectUrl(String projectUrl) {
    this.projectUrl = projectUrl;
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

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}
