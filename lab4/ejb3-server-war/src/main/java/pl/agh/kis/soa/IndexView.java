package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.payment.TestAddBean;
import pl.agh.kis.soa.ejb3.seats.controller.SeatsController;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import pl.agh.kis.soa.ejb3.seats.model.Seat;

@Named
@ViewScoped
public class IndexView implements Serializable {

    @EJB
    TestAddBean testAddBean;

    @EJB
    SeatsController seatsController;

    private int a = 0, b = 0;

    private List<String> test = List.of("_1_lalala", "_2_nanana", "_3_tatata");

    public IndexView() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public List<String> getTest() {
        return test;
    }

    public void setTest(List<String> test) {
        this.test = test;
    }

    public int calculateSum() {
        return testAddBean.add(a, b);
    }

    public List<Seat> displaySeats(){
        return seatsController.getSeatList();
    }
}
