package pl.kis.agh.soa.controller.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pl.kis.agh.soa.entities.Movie;

public class MovieDao extends AbstractDao {

  public MovieDao(EntityManager entityManager) {
    super(entityManager);
  }

  public List<Movie> findAll() {
    return this.getEntityManager()
        .createNamedQuery("Movie.findAll", Movie.class)
        .getResultList();
  }

  public Movie findOne(Long id) {
    return this.getEntityManager()
        .createNamedQuery("Movie.findOne", Movie.class)
        .setParameter("id", id)
        .getSingleResult();
  }
  public Movie findOne(String title) {
    return this.getEntityManager()
        .createNamedQuery("Movie.findTitle", Movie.class)
        .setParameter("title", title)
        .getSingleResult();
  }

  public void createOne(Movie b) {
    Movie added = new Movie(b);
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(added);
    entityManager.getTransaction().commit();
  }

  public void delete(Long chosenBookId) {
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.createNamedQuery("Movie.deleteOne").setParameter("id", chosenBookId).executeUpdate();
    entityManager.getTransaction().commit();
  }

  public void updateOne(Movie movie, Long chosenBookId) {
    EntityManager entityManager = this.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager
        .createNamedQuery("Movie.update")
        .setParameter("id", chosenBookId)
        .setParameter("title", movie.getTitle())
        .setParameter("year", movie.getUri())
        .executeUpdate();
    entityManager.getTransaction().commit();
  }
}
