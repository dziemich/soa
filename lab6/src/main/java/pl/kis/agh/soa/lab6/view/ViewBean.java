package pl.kis.agh.soa.lab6.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.kis.agh.soa.lab6.controller.LibraryController;
import pl.kis.agh.soa.lab6.entities.Author;
import pl.kis.agh.soa.lab6.entities.Book;
import pl.kis.agh.soa.lab6.entities.User;

@ManagedBean(name = "viewManager")
@SessionScoped
public class ViewBean {
  private Long pickedUserId;
  private Long chosenBookId;
  LibraryController libraryController;

  public ViewBean() {
    libraryController = new LibraryController();
  }

  public Long getPickedUserId() {
    return pickedUserId;
  }

  public void setPickedUserId(Long pickedUserId) {
    this.pickedUserId = pickedUserId;
  }

  public List<Author> findAllAuthors() {
    return libraryController.fetchAllAuthors();
  }

  public User findOneUser() {
    return libraryController.fetchOneUser(pickedUserId);
  }

  public List<User> findAllUsers(){
    return libraryController.fetchAllUsers();
  }

  public List<Book> findAllBooks(){
    return libraryController.fetchAllBooks();
  }

  public List<Book> findAllFreeBooks() {
    return libraryController.fetchAllFreeBooks();
  }

  public Long getChosenBookId() {
    return chosenBookId;
  }

  public void setChosenBookId(Long chosenBookId) {
    this.chosenBookId = chosenBookId;
  }

  public void borrowBook() {
    libraryController.borrowBook(pickedUserId, chosenBookId);
  }

}

