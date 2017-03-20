package ranobe.ru.rura_android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class ProjectDTO {

  @SerializedName("projectId") @Expose private Integer projectId;
  @SerializedName("imageId") @Expose private Integer imageId;
  @SerializedName("url") @Expose private String url;
  @SerializedName("title") @Expose private String title;
  @SerializedName("nameJp") @Expose private String nameJp;
  @SerializedName("nameEn") @Expose private String nameEn;
  @SerializedName("nameRu") @Expose private String nameRu;
  @SerializedName("nameRomaji") @Expose private String nameRomaji;
  @SerializedName("author") @Expose private String author;
  @SerializedName("illustrator") @Expose private String illustrator;
  @SerializedName("originalDesign") @Expose private String originalDesign;
  @SerializedName("originalStory") @Expose private String originalStory;
  @SerializedName("orderNumber") @Expose private Integer orderNumber;
  @SerializedName("onevolume") @Expose private Boolean onevolume;
  @SerializedName("franchiseNovel") @Expose private String franchiseNovel;
  @SerializedName("franchiseSpinOff") @Expose private String franchiseSpinOff;
  @SerializedName("franchiseSS") @Expose private String franchiseSS;
  @SerializedName("franchiseManga") @Expose private String franchiseManga;
  @SerializedName("franchiseAnime") @Expose private String franchiseAnime;
  @SerializedName("franchiseWeb") @Expose private String franchiseWeb;
  @SerializedName("annotation") @Expose private String annotation;
  @SerializedName("forumId") @Expose private Integer forumId;
  @SerializedName("status") @Expose private String status;
  @SerializedName("issueStatus") @Expose private String issueStatus;
  @SerializedName("translationStatus") @Expose private String translationStatus;
  @SerializedName("lastUpdateDate") @Expose private Date lastUpdateDate;
  @SerializedName("lastEditDate") @Expose private Date lastEditDate;

  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
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

  public String getNameJp() {
    return nameJp;
  }

  public void setNameJp(String nameJp) {
    this.nameJp = nameJp;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  public String getNameRu() {
    return nameRu;
  }

  public void setNameRu(String nameRu) {
    this.nameRu = nameRu;
  }

  public String getNameRomaji() {
    return nameRomaji;
  }

  public void setNameRomaji(String nameRomaji) {
    this.nameRomaji = nameRomaji;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIllustrator() {
    return illustrator;
  }

  public void setIllustrator(String illustrator) {
    this.illustrator = illustrator;
  }

  public String getOriginalDesign() {
    return originalDesign;
  }

  public void setOriginalDesign(String originalDesign) {
    this.originalDesign = originalDesign;
  }

  public String getOriginalStory() {
    return originalStory;
  }

  public void setOriginalStory(String originalStory) {
    this.originalStory = originalStory;
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Boolean getOnevolume() {
    return onevolume;
  }

  public void setOnevolume(Boolean onevolume) {
    this.onevolume = onevolume;
  }

  public String getFranchiseNovel() {
    return franchiseNovel;
  }

  public void setFranchiseNovel(String franchiseNovel) {
    this.franchiseNovel = franchiseNovel;
  }

  public String getFranchiseSpinOff() {
    return franchiseSpinOff;
  }

  public void setFranchiseSpinOff(String franchiseSpinOff) {
    this.franchiseSpinOff = franchiseSpinOff;
  }

  public String getFranchiseSS() {
    return franchiseSS;
  }

  public void setFranchiseSS(String franchiseSS) {
    this.franchiseSS = franchiseSS;
  }

  public String getFranchiseManga() {
    return franchiseManga;
  }

  public void setFranchiseManga(String franchiseManga) {
    this.franchiseManga = franchiseManga;
  }

  public String getFranchiseAnime() {
    return franchiseAnime;
  }

  public void setFranchiseAnime(String franchiseAnime) {
    this.franchiseAnime = franchiseAnime;
  }

  public String getFranchiseWeb() {
    return franchiseWeb;
  }

  public void setFranchiseWeb(String franchiseWeb) {
    this.franchiseWeb = franchiseWeb;
  }

  public String getAnnotation() {
    return annotation;
  }

  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  public Integer getForumId() {
    return forumId;
  }

  public void setForumId(Integer forumId) {
    this.forumId = forumId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getIssueStatus() {
    return issueStatus;
  }

  public void setIssueStatus(String issueStatus) {
    this.issueStatus = issueStatus;
  }

  public String getTranslationStatus() {
    return translationStatus;
  }

  public void setTranslationStatus(String translationStatus) {
    this.translationStatus = translationStatus;
  }

  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  public Date getLastEditDate() {
    return lastEditDate;
  }

  public void setLastEditDate(Date lastEditDate) {
    this.lastEditDate = lastEditDate;
  }
}