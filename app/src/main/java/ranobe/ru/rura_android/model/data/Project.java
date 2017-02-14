package ranobe.ru.rura_android.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

  @SerializedName("projectId")
  @Expose
  private Integer projectId;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("orderNumber")
  @Expose
  private Integer orderNumber;
  //@SerializedName("image")
  //@Expose
  //private Image image;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  //public Image getImage() {
  //  return image;
  //}
  //
  //public void setImage(Image image) {
  //  this.image = image;
  //}
}