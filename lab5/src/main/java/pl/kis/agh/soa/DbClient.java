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

  public void updateOne(String first_name2, String last_name2, String title2, String isbn2, Integer year2, String price2, Integer updatedId) {
    entityManager.getTransaction().begin();
    Query queryObj = entityManager.createQuery("UPDATE Book s SET s.first_name=:name, s.last_name=:surname, s.title=:title,s.isbn=:isbn,s.price=:price,s.year=:year WHERE s.id= :id");
    queryObj.setParameter("id", updatedId);
    queryObj.setParameter("name", first_name2);
    queryObj.setParameter("surname", last_name2);
    queryObj.setParameter("year", year2);
    queryObj.setParameter("isbn", isbn2);
    queryObj.setParameter("price", price2);
    queryObj.setParameter("title", title2);
    queryObj.executeUpdate();
    entityManager.getTransaction().commit();
  }
}
