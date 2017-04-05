package ranobe.ru.rura_android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeDTO {
  @SerializedName("volumeId") @Expose private Integer volumeId;
  @SerializedName("projectId") @Expose private Integer projectId;
  @SerializedName("imageOne") @Expose private Integer imageOne;
  @SerializedName("nameTitle") @Expose private String nameTitle;
  @SerializedName("sequenceNumber") @Expose private float sequenceNumber;
  @SerializedName("volumeType") @Expose private String volumeType;

  public Integer getVolumeId() {
    return volumeId;
  }

  public void setVolumeId(Integer volumeId) {
    this.volumeId = volumeId;
  }

  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public Integer getImageOne() {
    return imageOne;
  }

  public void setImageOne(Integer imageOne) {
    this.imageOne = imageOne;
  }

  public String getNameTitle() {
    return nameTitle;
  }

  public void setNameTitle(String nameTitle) {
    this.nameTitle = nameTitle;
  }

  public float getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(float sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public String getVolumeType() {
    return volumeType;
  }

  public void setVolumeType(String volumeType) {
    this.volumeType = volumeType;
  }
}
