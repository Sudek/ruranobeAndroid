package ranobe.ru.rura_android.presenter.vo;

import java.io.Serializable;
import java.util.List;

public class Text implements Serializable {
  private int textId;
  private int orderNumber;
  private String textHtml;
  private String contents;
  private String footnotes;
  private List<String> imageUrl;

  public Text(int textId, int orderNumber, String textHtml, String contents, String footnotes,
      List<String> imageUrl) {
    this.textId = textId;
    this.orderNumber = orderNumber;
    this.textHtml = textHtml;
    this.contents = contents;
    this.footnotes = footnotes;
    this.imageUrl = imageUrl;
  }

  public int getTextId() {
    return textId;
  }

  public void setTextId(int textId) {
    this.textId = textId;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    this.orderNumber = orderNumber;
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

  public List<String> getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(List<String> imageUrl) {
    this.imageUrl = imageUrl;
  }
}
