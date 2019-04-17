package pl.kis.agh.soa.lab6.controller.dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.lab6.entities.Book;
import pl.kis.agh.soa.lab6.entities.Loan;
import pl.kis.agh.soa.lab6.entities.User;

public class LoanDao extends AbstractDao {

  public LoanDao(EntityManager entityManager) {
    super(entityManager);
  }

  public void createOne(Long pickedUserId, Long chosenBookId){
    EntityManager entityManager = this.getEntityManager();

    User user = entityManager.createNamedQuery("User.findOne", User.class).setParameter("id", pickedUserId)
        .getSingleResult();
    Book book = entityManager.createNamedQuery("Book.findOne", Book.class).setParameter("id", chosenBookId)
        .getSingleResult();
    LocalDate loanDate = LocalDate.now();
    LocalDate returnDate = loanDate.plusMonths(1);


    entityManager.getTransaction().begin();
    entityManager.persist(new Loan(user, book, loanDate, returnDate));
    entityManager.getTransaction().commit();
  }

  public List<Loan> fetchAllById(Long pickedUserId) {
    return this.getEntityManager().createNamedQuery("Loan.findAllById", Loan.class).setParameter("id", pickedUserId).getResultList();
  }
}
