package pl.kis.agh.soa.lab6.controller;

import java.time.LocalDate;
import java.util.List;
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
}
