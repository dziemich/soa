package pl.kis.agh.soa.lab6.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.lab6.entities.User;

public class UserDao extends AbstractDao{

  public UserDao(EntityManager entityManager) {
    super(entityManager);
  }

  public List<User> findAll(){
    return this.getEntityManager()
        .createNamedQuery("User.findAll", User.class)
        .getResultList();
  }

  public User findOne(Long id) {
    return this.getEntityManager()
        .createNamedQuery("User.findOne", User.class)
        .setParameter("id", id)
        .getSingleResult();
  }
}
