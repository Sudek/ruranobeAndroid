package ranobe.ru.rura_android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterDTO {
  @SerializedName("chapterId") @Expose private Integer chapterId;
  @SerializedName("volumeId") @Expose private Integer volumeId;
  @SerializedName("textId") @Expose private Integer textId;
  @SerializedName("url") @Expose private String url;
  @SerializedName("title") @Expose private String title;
  @SerializedName("orderNumber") @Expose private Integer orderNumber;
  @SerializedName("publishDate") @Expose private String publishDate;
  @SerializedName("nested") @Expose private Boolean nested;
  @SerializedName("urlPart") @Expose private String urlPart;
  @SerializedName("published") @Expose private Boolean published;
  @SerializedName("leveledTitle") @Expose private String leveledTitle;

  public Integer getChapterId() {
    return chapterId;
  }

  public void setChapterId(Integer chapterId) {
    this.chapterId = chapterId;
  }

  public Integer getVolumeId() {
    return volumeId;
  }

  public void setVolumeId(Integer volumeId) {
    this.volumeId = volumeId;
  }

  public Integer getTextId() {
    return textId;
  }

  public void setTextId(Integer textId) {
    this.textId = textId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public String getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(String publishDate) {
    this.publishDate = publishDate;
  }

  public Boolean getNested() {
    return nested;
  }

  public void setNested(Boolean nested) {
    this.nested = nested;
  }

  public String getUrlPart() {
    return urlPart;
  }

  public void setUrlPart(String urlPart) {
    this.urlPart = urlPart;
  }

  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  public String getLeveledTitle() {
    return leveledTitle;
  }

  public void setLeveledTitle(String leveledTitle) {
    this.leveledTitle = leveledTitle;
  }
}
