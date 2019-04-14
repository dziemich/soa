package pl.kis.agh.soa.lab6.entities;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pl.kis.agh.soa.lab6.entities.models.Model;

@Entity
@Table(name = "loans")
public class Loan extends Model {
  @ManyToOne
  User renter;
  @ManyToOne
  Book book;
  @Column(name = "loan_date", nullable = false)
  LocalDate loanDate;
  @Column(name = "return_date", nullable = false)
  LocalDate returnDate;

  public Loan(User renter, Book book, LocalDate loanDate, LocalDate returnDate) {
    this.renter = renter;
    this.book = book;
    this.loanDate = loanDate;
    this.returnDate = returnDate;
  }

  public Loan() {
  }

  public User getRenter() {
    return renter;
  }

  public void setRenter(User renter) {
    this.renter = renter;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public LocalDate getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(LocalDate loanDate) {
    this.loanDate = loanDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }
}
