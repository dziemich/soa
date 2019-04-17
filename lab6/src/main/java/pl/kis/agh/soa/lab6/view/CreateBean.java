package pl.kis.agh.soa.lab6.view;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.kis.agh.soa.lab6.controller.LibraryController;
import pl.kis.agh.soa.lab6.entities.Author;
import pl.kis.agh.soa.lab6.entities.Book;

@ManagedBean(name = "createManager")
@SessionScoped
public class CreateBean {

  private Long authorId;
  private Author author;
  private Book book;
  private LibraryController libraryController;
  private Long chosenBookId;
  private Long updatedId;

  public CreateBean() {
    book = new Book();
    author = new Author();
    libraryController = new LibraryController();
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public void addBook() {
    libraryController.addBook(book, authorId);
  }

  public void addAuthor() {
    libraryController.addAuthor(author);
  }

  public Long getChosenBookId() {
    return chosenBookId;
  }

  public void setChosenBookId(Long chosenBookId) {
    this.chosenBookId = chosenBookId;
  }

  public Long getUpdatedId() {
    return updatedId;
  }

  public void setUpdatedId(Long updatedId) {
    this.updatedId = updatedId;
  }

  public void deleteBook() {
    libraryController.deleteBook(chosenBookId);
  }

  public void updateBook() {
    libraryController.updateBook(book, updatedId);
  }
}
