package ex4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@SessionScoped
@ManagedBean(name = "book")
public class BookBean {

  private Double priceFrom = 0.0;
  private Double priceTo = 1000.0;
  private List<String> title = null;
  private List<String> author = DataRepository.getAuthors();

  private List<String> genres = DataRepository.getGenres();
  private List<String> type = null;

  private String currency;
  private List<Integer> pages = null;

  private List<Book> select;

  public List<Book> getSelect() {
    return finalResult();
  }

  public void setSelect(List<Book> select) {
    this.select = select;
  }


  public void setTitle(List<String> title) {
    this.title = title;
  }

  public void setAuthor(List<String> author) {
    this.author = author;
  }

  public void setType(List<String> type) {
    this.type = type;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setPages(List<Integer> pages) {
    this.pages = pages;
  }

  public List<String> getTitle() {
    return title;
  }

  public List<String> getAuthor() {
    return author;
  }

  public List<String> getType() {
    return type;
  }

  public String getCurrency() {
    return currency;
  }

  public List<Integer> getPages() {
    return pages;
  }

  public LinkedList<Book> getBooks() {
    return books;
  }


  private LinkedList<Book> books = new LinkedList<Book>(Arrays.asList(
      new Book("Pippi Langstrumpf", "Astrid Lindgren", "kids", "PLN", 450, 25.0, false),
      new Book("Lalalala", "Stieg Larsson", "criminal", "EUR", 111, 50.0, false),
      new Book("The Reedbreast", "Jo Nesbo", "criminal", "GBP", 150, 29.90, false),
      new Book("Syzyfowe Prace", "Stefan Żeromski", "novel", "PLN", 1500, 45.90, false),
      new Book("Dzieci z Bullerbyn", "Astrid Lindgren", "kids", "PLN", 450, 25.0, false),
      new Book("Lalalala2", "Stieg Larsson", "criminal", "EUR", 111, 30.0, false),
      new Book("Trututu123", "Jo Nesbo", "criminal", "GBP", 150, 99.90, false),
      new Book("Przeminelo z wiatrem", "Stefan Żeromski", "novel", "PLN", 34, 17.90, false),
      new Book("The Lord Of The Rings", "J.R.R Tolkien", "fantasy", "PLN", 340, 117.90, false),
      new Book("Silmarillion", "J.R.R Tolkien", "fantasy", "GBP", 770, 57.90, false)
  ));

  public LinkedList<Book> getResult() {
    return filter();
  }

  public void setResult(LinkedList<Book> result) {
    this.result = result;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public void setBooks(LinkedList<Book> books) {
    this.books = books;
  }

  private LinkedList<Book> result = books;

  public LinkedList<Book> filter() {
    LinkedList<Book> toReturn = new LinkedList<>();
    for (Book book : books) {
      if (author.contains(book.getAuthor())
          && genres.contains(book.getType())
          && book.getPrice() >= priceFrom
          && book.getPrice() <= priceTo
          && !(toReturn.contains(book))) {
        if (currency != null) {
          if (book.getCurrency().equals("GBP")) {
            book.setPrice(book.getPrice() * 5);
          }
          if (book.getCurrency().equals("EUR")) {
            book.setPrice(book.getPrice() * 4);
          }
          book.setCurrency(currency);
        }
        toReturn.add(book);
      }
    }
    return toReturn;
  }

  public LinkedList<Book> finalResult() {
    LinkedList<Book> toReturn = new LinkedList<Book>();
    for (Book book : result
    ) {
      if (book.getSelect()) {
        toReturn.add(book);
      }
    }
    return toReturn;
  }



  public Double getPriceFrom() {
    return priceFrom;
  }

  public Double getPriceTo() {
    return priceTo;
  }

  public void setPriceFrom(Double priceFrom) {
    this.priceFrom = priceFrom;
  }

  public void setPriceTo(Double priceTo) {
    this.priceTo = priceTo;
  }

  public static double calculatePricePLN(Book book) {
    String currency = book.getCurrency();
    switch (currency) {
      case "GBP":
        return book.getPrice() * 5;
      case "EUR":
        return book.getPrice() * 4;
      case "PLN":
        return book.getPrice();
      default:
        return 0.0;
    }
  }

}
