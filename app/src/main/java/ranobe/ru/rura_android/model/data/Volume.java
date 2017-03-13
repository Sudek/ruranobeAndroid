package ranobe.ru.rura_android.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Volume {
  @SerializedName("volumeId")
  @Expose
  private Integer volumeId;
  @SerializedName("projectId")
  @Expose
  private Integer projectId;
  @SerializedName("imageOne")
  @Expose
  private Integer imageOne;
  @SerializedName("imageTwo")
  @Expose
  private Integer imageTwo;
  @SerializedName("imageThree")
  @Expose
  private Integer imageThree;
  @SerializedName("imageFour")
  @Expose
  private Integer imageFour;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("nameFile")
  @Expose
  private String nameFile;
  @SerializedName("nameTitle")
  @Expose
  private String nameTitle;
  @SerializedName("nameJp")
  @Expose
  private String nameJp;
  @SerializedName("nameEn")
  @Expose
  private String nameEn;
  @SerializedName("nameRu")
  @Expose
  private String nameRu;
  @SerializedName("nameRomaji")
  @Expose
  private String nameRomaji;
  @SerializedName("nameShort")
  @Expose
  private String nameShort;
  @SerializedName("sequenceNumber")
  @Expose
  private Float sequenceNumber;
  @SerializedName("author")
  @Expose
  private String author;
  @SerializedName("illustrator")
  @Expose
  private String illustrator;
  @SerializedName("originalDesign")
  @Expose
  private String originalDesign;
  @SerializedName("originalStory")
  @Expose
  private String originalStory;
  @SerializedName("releaseDate")
  @Expose
  private Date releaseDate;
  @SerializedName("isbn")
  @Expose
  private String isbn;
  @SerializedName("externalUrl")
  @Expose
  private String externalUrl;
  @SerializedName("volumeType")
  @Expose
  private String volumeType;
  @SerializedName("volumeStatus")
  @Expose
  private String volumeStatus;
  @SerializedName("adult")
  @Expose
  private Boolean adult;
  @SerializedName("annotation")
  @Expose
  private String annotation;
  @SerializedName("topicId")
  @Expose
  private Integer topicId;
  @SerializedName("requisiteId")
  @Expose
  private Integer requisiteId;
  @SerializedName("prevNameShort")
  @Expose
  private String prevNameShort;
  @SerializedName("prevUrl")
  @Expose
  private String prevUrl;
  @SerializedName("nextNameShort")
  @Expose
  private String nextNameShort;
  @SerializedName("nextUrl")
  @Expose
  private String nextUrl;
  @SerializedName("subProjectName")
  @Expose
  private String subProjectName;
  @SerializedName("lastUpdateDate")
  @Expose
  private Date lastUpdateDate;
  @SerializedName("lastEditDate")
  @Expose
  private Date lastEditDate;

  public void setImageTwo(Integer imageTwo) {
    this.imageTwo = imageTwo;
  }

  public void setImageThree(Integer imageThree) {
    this.imageThree = imageThree;
  }

  public void setImageFour(Integer imageFour) {
    this.imageFour = imageFour;
  }

  public void setNameRomaji(String nameRomaji) {
    this.nameRomaji = nameRomaji;
  }

  public void setSequenceNumber(Float sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public void setOriginalDesign(String originalDesign) {
    this.originalDesign = originalDesign;
  }

  public void setOriginalStory(String originalStory) {
    this.originalStory = originalStory;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public void setExternalUrl(String externalUrl) {
    this.externalUrl = externalUrl;
  }

  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  public void setRequisiteId(Integer requisiteId) {
    this.requisiteId = requisiteId;
  }

  public void setPrevNameShort(String prevNameShort) {
    this.prevNameShort = prevNameShort;
  }

  public void setPrevUrl(String prevUrl) {
    this.prevUrl = prevUrl;
  }

  public void setNextNameShort(String nextNameShort) {
    this.nextNameShort = nextNameShort;
  }

  public void setNextUrl(String nextUrl) {
    this.nextUrl = nextUrl;
  }

  public void setSubProjectName(String subProjectName) {
    this.subProjectName = subProjectName;
  }

  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  public void setLastEditDate(Date lastEditDate) {
    this.lastEditDate = lastEditDate;
  }

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

  public Object getImageTwo() {
    return imageTwo;
  }

  public Integer getImageThree() {
    return imageThree;
  }

  public Integer getImageFour() {
    return imageFour;
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

  public String getNameTitle() {
    return nameTitle;
  }

  public void setNameTitle(String nameTitle) {
    this.nameTitle = nameTitle;
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

  public Object getNameRomaji() {
    return nameRomaji;
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

  public Object getOriginalDesign() {
    return originalDesign;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Object getExternalUrl() {
    return externalUrl;
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

  public Boolean getAdult() {
    return adult;
  }

  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  public Object getAnnotation() {
    return annotation;
  }

  public Integer getTopicId() {
    return topicId;
  }

  public void setTopicId(Integer topicId) {
    this.topicId = topicId;
  }

  public Object getRequisiteId() {
    return requisiteId;
  }

  public Object getPrevNameShort() {
    return prevNameShort;
  }

  public Object getPrevUrl() {
    return prevUrl;
  }

  public Object getNextNameShort() {
    return nextNameShort;
  }

  public Object getNextUrl() {
    return nextUrl;
  }

  public Object getSubProjectName() {
    return subProjectName;
  }

  public Object getLastUpdateDate() {
    return lastUpdateDate;
  }

  public Object getLastEditDate() {
    return lastEditDate;
  }

  public String getNameShort() {
    return nameShort;
  }

  public void setNameShort(String nameShort) {
    this.nameShort = nameShort;
  }

  public Float getSequenceNumber() {
    return sequenceNumber;
  }

  public String getOriginalStory() {
    return originalStory;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }
}
