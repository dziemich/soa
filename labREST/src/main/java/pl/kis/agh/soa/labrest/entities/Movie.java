package pl.kis.agh.soa.labrest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import pl.kis.agh.soa.labrest.entities.models.Model;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Movie.findAll",
        query = "SELECT book FROM Movie book"
    ),
    @NamedQuery(
        name = "Movie.findOne",
        query = "SELECT book FROM Movie book WHERE id = :id"
    ),
    @NamedQuery(
        name = "Movie.update",
        query = "UPDATE Movie movie SET movie.title = :title, movie.year = :year WHERE id = :id"
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
  Integer year;

  public Movie(List<User> users, String title, Integer year) {
    this.users = users;
    this.title = title;
    this.year = year;
  }

  public Movie(String title, Integer year) {
    this.title = title;
    this.year = year;
  }


  public Movie(Movie m) {
    this.users = m.users;
    this.title = m.title;
    this.year = m.year;
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

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }
}
