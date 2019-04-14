package pl.kis.agh.soa.lab6.controller.dao;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.lab6.entities.Book;
import pl.kis.agh.soa.lab6.entities.Loan;
import pl.kis.agh.soa.lab6.entities.User;

public class LoanDao extends AbstractDao {

  public LoanDao(EntityManager entityManager) {
    super(entityManager);
  }

  public void createOne(Long pickedUserId, Long chosenBookId){

    User user = getEntityManager().createNamedQuery("User.findOne", User.class).setParameter("id", pickedUserId)
        .getSingleResult();
    Book book = getEntityManager().createNamedQuery("Book.findOne", Book.class).setParameter("id", chosenBookId)
        .getSingleResult();
    LocalDate loanDate = LocalDate.now();
    LocalDate returnDate = loanDate.plusMonths(1);

    EntityManager entityManager = this.getEntityManager();

    entityManager.getTransaction().begin();
    entityManager.persist(new Loan(user, book, loanDate, returnDate));
    entityManager.getTransaction().commit();
  }
}
