package ranobe.ru.rura_android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TextDTO {
  @SerializedName("textId") @Expose private Integer textId;
  @SerializedName("textHtml") @Expose private String textHtml;
  @SerializedName("contents") @Expose private String contents;
  @SerializedName("footnotes") @Expose private String footnotes;

  public Integer getTextId() {
    return textId;
  }

  public void setTextId(Integer textId) {
    this.textId = textId;
  }

  public String getTextHtml() {
    return textHtml;
  }

  public void setTextHtml(String textHtml) {
    this.textHtml = textHtml;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getFootnotes() {
    return footnotes;
  }

  public void setFootnotes(String footnotes) {
    this.footnotes = footnotes;
  }
}
