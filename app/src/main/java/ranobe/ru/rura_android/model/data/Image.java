package ranobe.ru.rura_android.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
  @SerializedName("resourceId") @Expose private Integer resourceId;
  @SerializedName("userId") @Expose private Integer userId;
  @SerializedName("historyId") @Expose private Integer historyId;
  @SerializedName("width") @Expose private Integer width;
  @SerializedName("height") @Expose private Integer height;
  @SerializedName("mimeType") @Expose private String mimeType;
  @SerializedName("url") @Expose private String url;
  @SerializedName("thumbnail") @Expose private String thumbnail;
  @SerializedName("title") @Expose private String title;
  @SerializedName("uploadedWhen") @Expose private String uploadedWhen;
  @SerializedName("nonColored") @Expose private Object nonColored;

  public Integer getResourceId() {
    return resourceId;
  }

  public void setResourceId(Integer resourceId) {
    this.resourceId = resourceId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getHistoryId() {
    return historyId;
  }

  public void setHistoryId(Integer historyId) {
    this.historyId = historyId;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUploadedWhen() {
    return uploadedWhen;
  }

  public void setUploadedWhen(String uploadedWhen) {
    this.uploadedWhen = uploadedWhen;
  }

  public Object getNonColored() {
    return nonColored;
  }

  public void setNonColored(Object nonColored) {
    this.nonColored = nonColored;
  }
}
