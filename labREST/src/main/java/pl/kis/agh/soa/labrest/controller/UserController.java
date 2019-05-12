package pl.kis.agh.soa.labrest.controller;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pl.kis.agh.soa.labrest.controller.dao.UserDao;
import pl.kis.agh.soa.labrest.controller.dao.MovieDao;
import pl.kis.agh.soa.labrest.entities.User;
import pl.kis.agh.soa.labrest.entities.Movie;

@ManagedBean
public class UserController {
  private UserDao userDao;
  private MovieDao movieDao;

  public UserController(){
    EntityManager entityManager = Persistence.createEntityManagerFactory("Library")
        .createEntityManager();
    movieDao = new MovieDao(entityManager);
    userDao = new UserDao(entityManager);
  }

  public List<User> fetchAllUsers(){
    return userDao.findAll();
  }

  public User fetchOneUser(Long pickedUserId) {
    return userDao.findOneById(pickedUserId);
  }

  public List<Movie> fetchAllMovies() {
    return movieDao.findAll();
  }

  public void addUser(User user) {
    userDao.createOne(user);
  }

  public void deleteMovie(Long chosenBookId) {
    movieDao.delete(chosenBookId);
  }

  public void updateMovie(Movie movie, Long updatedId) {
    movieDao.updateOne(movie, updatedId);
  }

  public void deleteUser(Long id) {
    userDao.deleteOne(id);
  }
}
