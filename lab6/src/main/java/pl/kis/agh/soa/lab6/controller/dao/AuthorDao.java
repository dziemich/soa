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

  public Author findOne(Long id) {
    return this.getEntityManager()
        .createNamedQuery("Author.findOne", Author.class)
        .setParameter("id", id)
        .getSingleResult();
  }
}
