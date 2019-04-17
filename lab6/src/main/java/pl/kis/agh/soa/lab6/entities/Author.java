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
        name = "Author.findOneById",
        query = "SELECT author FROM Author author WHERE id = :id"
    ),
    @NamedQuery(
        name = "Author.findOneByName",
        query = "SELECT author FROM Author author WHERE firstName = :fname and lastName = :lname"
    )
})
@Table(name = "authors")
public class Author extends PersonModel {

  @OneToMany(mappedBy = "author")
  List<Book> books;

  public Author() {
  }

  public Author(Author a) {
    super(a);
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }


}
