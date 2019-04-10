package pl.kis.agh.soa;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

@RequestScoped
@ManagedBean(name = "dbclient")
public class DbClient {
  private static EntityManager entityManager;

  public DbClient() {
    entityManager = Persistence.createEntityManagerFactory("BooksPersistence").createEntityManager();
  }

  public List getAll(){
    Query queryObj = entityManager.createQuery("SELECT s FROM Book s");
    return queryObj.getResultList();
  }

  public void addOne(Book book) {
    entityManager.getTransaction().begin();
    entityManager.persist(book);
    entityManager.getTransaction().commit();
  }

  public void deleteOne(Integer id){
    Book foundBook = entityManager.find(Book.class, id);

    entityManager.getTransaction().begin();
    entityManager.remove(foundBook);
    entityManager.getTransaction().commit();
  }

  public void updateOne(Book updated, Integer updatedId) {
    entityManager.getTransaction().begin();
    Query queryObj = entityManager.createQuery("UPDATE Book s SET s.first_name=:name, s.last_name=:surname, s.title=:title,s.isbn=:isbn,s.price=:price,s.year=:year WHERE s.id= :id");
    queryObj.setParameter("id", updatedId);
    queryObj.setParameter("name", updated.getFirst_name());
    queryObj.setParameter("surname", updated.getLast_name());
    queryObj.setParameter("year", updated.getYear());
    queryObj.setParameter("isbn", updated.getIsbn());
    queryObj.setParameter("price", updated.getPrice());
    queryObj.setParameter("title", updated.getTitle());
    queryObj.executeUpdate();
    entityManager.getTransaction().commit();
  }
}
