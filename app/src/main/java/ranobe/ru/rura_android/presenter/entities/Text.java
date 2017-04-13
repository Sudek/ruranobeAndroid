package ranobe.ru.rura_android.presenter.entities;

public class Text {
  private Integer textId;
  private String textHtml;
  private String contents;
  private String footnotes;

  public Text(Integer textId, String textHtml, String contents, String footnotes) {
    this.textId = textId;
    this.textHtml = textHtml;
    this.contents = contents;
    this.footnotes = footnotes;
  }

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
