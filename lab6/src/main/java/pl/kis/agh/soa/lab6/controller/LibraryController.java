package pl.kis.agh.soa.lab6.controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pl.kis.agh.soa.lab6.controller.dao.AuthorDao;
import pl.kis.agh.soa.lab6.controller.dao.BookDao;
import pl.kis.agh.soa.lab6.controller.dao.LoanDao;
import pl.kis.agh.soa.lab6.controller.dao.UserDao;
import pl.kis.agh.soa.lab6.entities.Author;
import pl.kis.agh.soa.lab6.entities.Book;
import pl.kis.agh.soa.lab6.entities.Loan;
import pl.kis.agh.soa.lab6.entities.User;

public class LibraryController {
  private UserDao userDao;
  private BookDao bookDao;
  private LoanDao loanDao;
  private AuthorDao authorDao;

  public LibraryController(){
    EntityManager entityManager = Persistence.createEntityManagerFactory("Library")
        .createEntityManager();
    userDao = new UserDao(entityManager);
    bookDao = new BookDao(entityManager);
    loanDao = new LoanDao(entityManager);
    authorDao = new AuthorDao(entityManager);
  }

  public List<User> fetchAllUsers(){
    return userDao.findAll();
  }

  public User fetchOneUser(Long pickedUserId) {
    return userDao.findOne(pickedUserId);
  }

  public List<Book> fetchAllBooks() {
    return bookDao.findAll();
  }

  public List<Book> fetchAllFreeBooks() {
    return bookDao.findAllFree();
  }

  public List<Author> fetchAllAuthors() {
    return authorDao.findAll();
  }

  public void borrowBook(Long pickedUserId, Long chosenBookId) {
    bookDao.setTaken(chosenBookId);
    loanDao.createOne(pickedUserId, chosenBookId);
  }

  public void addAuthor(Author author) {
    authorDao.createOne(author);
  }

  public void addBook(Book book, Long authorId) {
    // TODO: add exception handling on no author found
    try{
      Author author = authorDao.findOneById(authorId);
      book.setAuthor(author);
      bookDao.createOne(book);
    }catch (Exception e ){
      System.out.println("nie ma autora");
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_ERROR,
          "Author is missing", null));
    }

  }

  public List<Loan> fetchAllLoansOfAUser(Long pickedUserId) {
    return loanDao.fetchAllById(pickedUserId);
  }

  public void deleteBook(Long chosenBookId) {
    bookDao.delete(chosenBookId);
  }

  public void updateBook(Book book, Long updatedId) {
    bookDao.updateOne(book, updatedId);
  }
}
