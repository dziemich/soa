package pl.agh.kis.soa.ejb3.seats.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import pl.agh.kis.soa.ejb3.seats.model.Client;
import pl.agh.kis.soa.ejb3.seats.model.Seat;

@Stateful
public class PaymentController {

    Client client;

    @PostConstruct
    void init(){
        client = new Client(500.0);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getClientsBalance(){
        return client.getBalance();
    }

    public boolean verify(Seat seat){
        return seat.getTaken() && seat.getPrice() < client.getBalance();
    }
}
