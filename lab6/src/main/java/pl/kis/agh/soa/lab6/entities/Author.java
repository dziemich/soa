package pl.kis.agh.soa.lab6.entities;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pl.kis.agh.soa.lab6.entities.models.PersonModel;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Author.findAll",
        query = "SELECT author FROM Author author"
    ),
    @NamedQuery(
        name = "Author.findOne",
        query = "SELECT author FROM Author author WHERE id = :id"
    )
})
@Table(name = "authors")
public class Author extends PersonModel {
  @OneToMany(mappedBy = "author")
  List<Book> books;

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
