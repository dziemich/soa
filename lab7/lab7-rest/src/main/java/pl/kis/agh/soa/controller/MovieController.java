package pl.kis.agh.soa.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pl.kis.agh.soa.controller.dao.MovieDao;
import pl.kis.agh.soa.entities.Movie;

public class MovieController {

  private MovieDao movieDao;

  public MovieController() {
    EntityManager entityManager = Persistence.createEntityManagerFactory("Library")
        .createEntityManager();
    movieDao = new MovieDao(entityManager);
  }

  public List<Movie> fetchAllMovies() {
    return movieDao.findAll();
  }

  public void deleteMovie(Long chosenBookId) {
    movieDao.delete(chosenBookId);
  }

  public void updateMovie(Movie movie, Long updatedId) {
    movieDao.updateOne(movie, updatedId);
  }

  public Movie fetchMovie(String title) {
    return movieDao.findOne(title);
  }
}
