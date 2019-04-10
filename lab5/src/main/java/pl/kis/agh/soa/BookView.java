package pl.kis.agh.soa;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@ManagedBean(name = "bookview")
public class BookView {

  @Inject
  private DbClient dbClient;

  private String title;
  private String first_name;
  private String last_name;
  private String isbn;
  private Integer year;
  private String price;
  private Integer deletedId;
  private String title2;
  private String first_name2;
  private String last_name2;
  private String isbn2;
  private Integer year2;
  private String price2;
  private Integer updatedId;

  public BookView() {
    dbClient = new DbClient();
  }

  public DbClient getDbClient() {
    return dbClient;
  }

  public void setDbClient(DbClient dbClient) {
    this.dbClient = dbClient;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public Integer getDeletedId() {
    return deletedId;
  }

  public void setDeletedId(Integer deletedId) {
    this.deletedId = deletedId;
  }

  public String getTitle2() {
    return title2;
  }

  public void setTitle2(String title2) {
    this.title2 = title2;
  }

  public String getFirst_name2() {
    return first_name2;
  }

  public void setFirst_name2(String first_name2) {
    this.first_name2 = first_name2;
  }

  public String getLast_name2() {
    return last_name2;
  }

  public void setLast_name2(String last_name2) {
    this.last_name2 = last_name2;
  }

  public String getIsbn2() {
    return isbn2;
  }

  public void setIsbn2(String isbn2) {
    this.isbn2 = isbn2;
  }

  public Integer getYear2() {
    return year2;
  }

  public void setYear2(Integer year2) {
    this.year2 = year2;
  }

  public String getPrice2() {
    return price2;
  }

  public void setPrice2(String price2) {
    this.price2 = price2;
  }

  public Integer getUpdatedId() {
    return updatedId;
  }

  public void setUpdatedId(Integer updatedId) {
    this.updatedId = updatedId;
  }

  public List findBooks(){
    return dbClient.getAll();
  }

  public void addBook() {
    dbClient.addOne(new Book(first_name, last_name, title, isbn, year, price));
  }

  public void deleteBook(){
    dbClient.deleteOne(deletedId);
  }

  public void updateBook(){
    dbClient.updateOne(first_name2, last_name2, title2, isbn2, year2, price2, updatedId);
  }
}
