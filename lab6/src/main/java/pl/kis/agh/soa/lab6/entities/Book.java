package pl.kis.agh.soa.lab6.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import pl.kis.agh.soa.lab6.entities.models.Model;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Book.findAll",
        query = "SELECT book FROM Book book"
    ),
    @NamedQuery(
        name = "Book.findOne",
        query = "SELECT book FROM Book book WHERE id = :id"
    ),
    @NamedQuery(
        name = "Book.findAllFree",
        query = "SELECT book FROM Book book WHERE taken = false"
    ),
    @NamedQuery(
        name = "Book.setTaken",
        query = "UPDATE Book book SET book.taken = true WHERE id = :id"
    ),
    @NamedQuery(
        name = "Book.update",
        query = "UPDATE Book book SET book.author.id = :authorId, book.title = :title, book.isbn = :isbn, book.year = :year WHERE id = :id"
    ),
    @NamedQuery(
        name = "Book.deleteOne",
        query = "DELETE Book book WHERE id = :id"
    )
})
@Table(name = "books")
public class Book extends Model {
  @ManyToOne(cascade = CascadeType.ALL)
  Author author;
  @Column(nullable = false)
  String title;
  @Column(nullable = false)
  String isbn;
  @Column(nullable = false)
  Integer year;
  @Column (nullable = false)
  Boolean taken;
  @OneToMany
  List<User> renters;

  public Book() {
    this.taken = false;
    this.author = new Author();
  }

  public Book(Book b){
    this();
    this.author = b.getAuthor();
    this.title = b.getTitle();
    this.isbn = b.getIsbn();
    this.year = b.getYear();
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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
  public List<User> getRenters() {
    return renters;
  }

  public void setRenters(List<User> renters) {
    this.renters = renters;
  }
}
