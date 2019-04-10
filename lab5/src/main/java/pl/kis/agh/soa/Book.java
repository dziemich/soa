package pl.kis.agh.soa;

import java.time.Instant;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "books")
@NamedQuery(name="Books.findAll", query="SELECT b FROM Book b")
public class Book {
  Integer id;
  String first_name;
  String last_name;
  String title;
  String isbn;
  Integer year;
  String price;

  public Book() {}

  public Book(
      String first_name,
      String last_name,
      String title,
      String isbn,
      Integer year,
      String price) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.title = title;
    this.isbn = isbn;
    this.year = year;
    this.price = price;
  }

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "first_name")
  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  @Column(name = "last_name")
  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  @Column(name = "title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "isbn")
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Column(name = "year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Column(name = "price")
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

}
