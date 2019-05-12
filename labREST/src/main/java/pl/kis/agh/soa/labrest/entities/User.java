package pl.kis.agh.soa.labrest.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import pl.kis.agh.soa.labrest.entities.models.PersonModel;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "User.findAll",
        query = "SELECT author FROM User author"
    ),
    @NamedQuery(
        name = "User.findOneById",
        query = "SELECT author FROM User author WHERE id = :id"
    ),
    @NamedQuery(
        name = "User.findOneByName",
        query = "SELECT author FROM User author WHERE firstName = :fname and lastName = :lname"
    ),
    @NamedQuery(
        name = "User.deleteOne",
        query = "DELETE  FROM User user WHERE id = :id"
    )
})
@Table(name = "movieusers")
public class User extends PersonModel {

  @ManyToMany(cascade = CascadeType.ALL)
  List<Movie> movies;

  public User() {
  }

  public User(User a) {
    super(a);
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }


}
