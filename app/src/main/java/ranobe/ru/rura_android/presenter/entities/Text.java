package ranobe.ru.rura_android.presenter.entities;

import java.util.ArrayList;

public class Text {
  private int textId;
  private int orderNumber;
  private String textHtml;
  private String contents;
  private String footnotes;
  private ArrayList<String> imageUri;

  public Text(int textId, int orderNumber, String textHtml, String contents, String footnotes) {
    this.textId = textId;
    this.orderNumber = orderNumber;
    this.textHtml = textHtml;
    this.contents = contents;
    this.footnotes = footnotes;
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

  public ArrayList<String> getImageUri() {
    return imageUri;
  }

  public void setImageUri(ArrayList<String> imageUri) {
    this.imageUri = imageUri;
  }
}
