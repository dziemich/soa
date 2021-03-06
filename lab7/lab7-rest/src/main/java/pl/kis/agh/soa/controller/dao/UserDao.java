package pl.kis.agh.soa.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.entities.User;

public class UserDao extends AbstractDao {

  public UserDao(EntityManager entityManager) {
    super(entityManager);
  }

  public List<User> findAll(){
    return this.getEntityManager()
        .createNamedQuery("User.findAll", User.class)
        .getResultList();
  }

  public User findOneById(Long id) {
    return this.getEntityManager()
        .createNamedQuery("User.findOneById", User.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  public User findOneByName(String fname, String lname) {
    return this.getEntityManager()
        .createNamedQuery("User.findOneByName", User.class)
        .setParameter("fname", fname)
        .setParameter("lname", lname)
        .getSingleResult();
  }

  public void createOne(User a) {
    User add = new User(a);
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(add);
    entityManager.getTransaction().commit();
  }

  public void deleteOne(Long id){
    this.getEntityManager()
        .createNamedQuery("User.deleteOne", User.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  public void updateOne(Long id, User user) {
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager
        .createNamedQuery("User.update")
        .setParameter("id", id)
        .setParameter("firstName", user.getFirstName())
        .setParameter("lastName", user.getLastName())
        .setParameter("age", user.getAge())
        .executeUpdate();
    entityManager.getTransaction().commit();
  }
}
