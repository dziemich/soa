package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.seats.controller.PaymentController;
import pl.agh.kis.soa.ejb3.seats.controller.SeatsController;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import pl.agh.kis.soa.ejb3.commons.model.Seat;

@Named
@ViewScoped
public class IndexView implements Serializable {

    @EJB
    PaymentController paymentController;

    @EJB
    SeatsController seatsController;

    public IndexView() {
    }

    public List<Seat> displaySeats(){
        return seatsController.getSeatList();
    }

    public Double getClientsBalance(){
        return paymentController.getClientsBalance();
    }

    public void buyTickets(){
        Double money = seatsController.buyTickets();
        paymentController.getClient().setBalance(paymentController.getClientsBalance() - money);
    }
}
