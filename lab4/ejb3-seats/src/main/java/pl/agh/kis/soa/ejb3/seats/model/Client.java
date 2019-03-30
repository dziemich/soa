package pl.agh.kis.soa.ejb3.seats.model;

public class Client {
  private Double balance;

  public Client(Double balance) {
    this.balance = balance;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }
}
