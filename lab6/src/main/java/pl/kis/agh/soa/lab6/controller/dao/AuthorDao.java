package pl.kis.agh.soa.lab6.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.lab6.entities.Author;
import pl.kis.agh.soa.lab6.entities.User;

public class AuthorDao extends AbstractDao {

  public AuthorDao(EntityManager entityManager) {
    super(entityManager);
  }

  public List<Author> findAll(){
    return this.getEntityManager()
        .createNamedQuery("Author.findAll", Author.class)
        .getResultList();
  }

  public Author findOneById(Long id) {
    return this.getEntityManager()
        .createNamedQuery("Author.findOneById", Author.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  public Author findOneByName(String fname, String lname) {
    return this.getEntityManager()
        .createNamedQuery("Author.findOneByName", Author.class)
        .setParameter("fname", fname)
        .setParameter("lname", lname)
        .getSingleResult();
  }

  public void createOne(Author a) {
    Author add = new Author(a);
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(add);
    entityManager.getTransaction().commit();
  }
}
