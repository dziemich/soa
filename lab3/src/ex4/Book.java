package ex4;

public class Book {

  public Book(String title, String author, String type, String currency, Integer pages,
      Double price, Boolean select) {
    this.title = title;
    this.author = author;
    this.type = type;
    this.currency = currency;
    this.pages = pages;
    this.price = price;
    this.select = select;
  }
  private String title;
  private String author;
  private String type;
  private String currency;
  private Integer pages;
  private Double price;
  private Boolean select;


  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getType() {
    return type;
  }

  public String getCurrency() {
    return currency;
  }

  public Integer getPages() {
    return pages;
  }

  public Double getPrice() {
    return price;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  public Boolean getSelect() {
    return select;
  }

  public void setSelect(Boolean select) {
    this.select = select;
  }

}
