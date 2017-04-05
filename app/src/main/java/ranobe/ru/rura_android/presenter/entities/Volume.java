package ranobe.ru.rura_android.presenter.entities;

import java.io.Serializable;

public class Volume implements Serializable {

  private int projectId;
  private int volumeId;
  private int index;
  private String name;
  private int coverId;

  public Volume(int projectId, int volumeId, int index, String name, int coverId) {
    this.projectId = projectId;
    this.volumeId = volumeId;
    this.index = index;
    this.name = name;
    this.coverId = coverId;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public int getVolumeId() {
    return volumeId;
  }

  public void setVolumeId(int volumeId) {
    this.volumeId = volumeId;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCoverId() {
    return coverId;
  }

  public void setCoverId(int coverId) {
    this.coverId = coverId;
  }
}
