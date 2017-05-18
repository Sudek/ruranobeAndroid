package ranobe.ru.rura_android.presenter.vo;

import java.io.Serializable;

public class Volume implements Serializable {

  private int projectId;
  private int volumeId;
  private float index;
  private String name;
  private int coverId;
  private String volumeType;
  private String volumeStatus;
  private String nameRu;
  private String url;
  private String nameFile;

  public Volume(int projectId, int volumeId, float index, String name, int coverId,
      String volumeType, String volumeStatus, String nameRu, String url, String nameFile) {
    this.projectId = projectId;
    this.volumeId = volumeId;
    this.index = index;
    this.name = name;
    this.coverId = coverId;
    this.volumeType = volumeType;
    this.volumeStatus = volumeStatus;
    this.nameRu = nameRu;
    this.url = url;
    this.nameFile = nameFile;
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

  public float getIndex() {
    return index;
  }

  public void setIndex(float index) {
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

  public String getVolumeType() {
    return volumeType;
  }

  public void setVolumeType(String volumeType) {
    this.volumeType = volumeType;
  }

  public String getVolumeStatus() {
    return volumeStatus;
  }

  public void setVolumeStatus(String volumeStatus) {
    this.volumeStatus = volumeStatus;
  }

  public String getNameRu() {
    return nameRu;
  }

  public void setNameRu(String nameRu) {
    this.nameRu = nameRu;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getNameFile() {
    return nameFile;
  }

  public void setNameFile(String nameFile) {
    this.nameFile = nameFile;
  }
}
