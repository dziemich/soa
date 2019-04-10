package pl.kis.agh.soa;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@ManagedBean(name = "bookview")
public class BookView {

  @Inject
  private DbClient dbClient;

  private Book added;
  private Book updated;

  private Integer deletedId;
  private Integer updatedId;

  public BookView() {
    dbClient = new DbClient();
  }

  public DbClient getDbClient() {
    return dbClient;
  }

  public void setDbClient(DbClient dbClient) {
    this.dbClient = dbClient;
  }

  public Book getAdded() {
    return added;
  }

  public void setAdded(Book added) {
    this.added = added;
  }

  public Book getUpdated() {
    return updated;
  }

  public void setUpdated(Book updated) {
    this.updated = updated;
  }

  public Integer getDeletedId() {
    return deletedId;
  }

  public void setDeletedId(Integer deletedId) {
    this.deletedId = deletedId;
  }

  public Integer getUpdatedId() {
    return updatedId;
  }

  public void setUpdatedId(Integer updatedId) {
    this.updatedId = updatedId;
  }

  public List findBooks(){
    return dbClient.getAll();
  }


  @PostConstruct
  public void init() {
    added = new Book();
    updated = new Book();
  }

  public void addBook() {
    dbClient.addOne(added);
  }

  public void deleteBook(){
    dbClient.deleteOne(deletedId);
  }

  public void updateBook(){
    dbClient.updateOne(updated, updatedId);
  }
}
