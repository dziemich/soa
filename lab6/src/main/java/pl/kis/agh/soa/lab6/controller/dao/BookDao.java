package pl.kis.agh.soa.lab6.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.lab6.entities.Author;
import pl.kis.agh.soa.lab6.entities.Book;

public class BookDao extends AbstractDao {

  public BookDao(EntityManager entityManager) {
    super(entityManager);
  }

  public List<Book> findAll() {
    return this.getEntityManager()
        .createNamedQuery("Book.findAll", Book.class)
        .getResultList();
  }

  public List<Book> findAllFree() {
    return this.getEntityManager()
        .createNamedQuery("Book.findAllFree", Book.class)
        .getResultList();
  }

  public Book findOne(Long id) {
    return this.getEntityManager()
        .createNamedQuery("Book.findOne", Book.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  public void setTaken(Long chosenBookId) {
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager
        .createNamedQuery("Book.setTaken")
        .setParameter("id", chosenBookId)
        .executeUpdate();
    entityManager.getTransaction().commit();
  }

  public void createOne(Book b) {
    Book added = new Book(b);
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(added);
    entityManager.getTransaction().commit();
  }

  public void delete(Long chosenBookId) {
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.createNamedQuery("Book.deleteOne").setParameter("id", chosenBookId).executeUpdate();
    entityManager.getTransaction().commit();
  }

  public void updateOne(Book book, Long chosenBookId) {
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager
        .createNamedQuery("Book.update")
        .setParameter("id", chosenBookId)
        .setParameter("authorId", book.getAuthor().getId())
        .setParameter("title", book.getTitle())
        .setParameter("year", book.getYear())
        .setParameter("isbn", book.getIsbn())
        .executeUpdate();
    entityManager.getTransaction().commit();
  }
}
