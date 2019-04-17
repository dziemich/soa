package pl.kis.agh.soa.lab6.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import pl.kis.agh.soa.lab6.entities.models.PersonModel;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "User.findAll",
        query = "SELECT user FROM User user"
    ),
    @NamedQuery(
        name = "User.findOne",
        query = "SELECT user FROM User user WHERE id = :id"
    )
})
@Table(name = "users")
public class User extends PersonModel {
  @OneToMany(mappedBy = "renter")
  List<Loan> loans;

  public User(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public User(String firstName, String lastName,
      List<Loan> loans) {
    super(firstName, lastName);
    this.loans = loans;
  }

  public User() {
  }

  public List<Loan> getLoans() {
    return loans;
  }

  public void setLoans(List<Loan> loans) {
    this.loans = loans;
  }
}
