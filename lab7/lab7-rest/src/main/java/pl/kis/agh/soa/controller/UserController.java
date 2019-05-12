package pl.kis.agh.soa.controller;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pl.kis.agh.soa.controller.dao.UserDao;
import pl.kis.agh.soa.entities.User;

@ManagedBean
public class UserController {

  private UserDao userDao;

  public UserController() {
    EntityManager entityManager = Persistence.createEntityManagerFactory("Library")
        .createEntityManager();
    userDao = new UserDao(entityManager);
  }

  public List<User> fetchAllUsers() {
    return userDao.findAll();
  }

  public User fetchOneUser(Long pickedUserId) {
    return userDao.findOneById(pickedUserId);
  }


  public void addOne(User user) {
    userDao.createOne(user);
  }

  public void deleteOne(Long id) {
    userDao.deleteOne(id);
  }

  public void updateOne(Long id, User user) {
    userDao.updateOne(id, user);
  }
}
