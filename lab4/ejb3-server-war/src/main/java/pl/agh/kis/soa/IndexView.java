package pl.agh.kis.soa;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pl.agh.kis.soa.ejb3.commons.exception.CustomISException;
import pl.agh.kis.soa.ejb3.commons.model.Seat;
import pl.agh.kis.soa.ejb3.seats.PaymentController;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import pl.agh.kis.soa.ejb3.seats.SeatsController;

@Named
@ViewScoped
public class IndexView implements Serializable {

  @EJB
  PaymentController paymentController;

  @EJB
  SeatsController seatsController;

  public IndexView() {
  }

  public List<Seat> displaySeats() {
    return seatsController.getSeatList();
  }

  public Double getClientsBalance() {
    return paymentController.getClientsBalance();
  }

  public void buyTickets() {
    Double money = seatsController.calculateTicketPrice();
    try {
      paymentController.verify(money);
      paymentController.getClient().setBalance(paymentController.getClientsBalance() - money);
      seatsController.markSeatsAsTaken();
    } catch (CustomISException ise){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_ERROR,
          "Not enough money to perform the operation", null));
    }
  }
}
