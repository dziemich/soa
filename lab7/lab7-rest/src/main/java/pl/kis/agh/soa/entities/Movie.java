package pl.kis.agh.soa.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import pl.kis.agh.soa.entities.models.Model;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Movie.findAll",
        query = "SELECT movie FROM Movie movie"
    ),
    @NamedQuery(
        name = "Movie.findOne",
        query = "SELECT movie FROM Movie movie WHERE id = :id"
    ),
    @NamedQuery(
        name = "Movie.findTitle",
        query = "SELECT movie FROM Movie movie WHERE title = :title"
    ),
    @NamedQuery(
        name = "Movie.update",
        query = "UPDATE Movie movie SET movie.title = :title, movie.uri = :year WHERE id = :id"
    ),
    @NamedQuery(
        name = "Movie.deleteOne",
        query = "DELETE Movie movie WHERE id = :id"
    )
})
@Table(name = "movies")
public class Movie extends Model {
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "movies")
  @JsonIgnore
  List<User> users;
  @Column(nullable = false)
  String title;
  @Column(nullable = false)
  String uri;

  public Movie(List<User> users, String title, String uri) {
    this.users = users;
    this.title = title;
    this.uri = uri;
  }

  public Movie(String title, String uri) {
    this.title = title;
    this.uri = uri;
  }


  public Movie(Movie m) {
    this.users = m.users;
    this.title = m.title;
    this.uri = m.uri;
  }

  public Movie() {
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String year) {
    this.uri = year;
  }
}
