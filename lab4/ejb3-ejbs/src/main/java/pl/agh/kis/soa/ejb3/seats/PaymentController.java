package pl.agh.kis.soa.ejb3.payment;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pl.agh.kis.soa.ejb3.commons.model.Client;

@Stateful
public class PaymentController {

    Client client;

    @PostConstruct
    void init(){
        client = new Client(150.0);
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

    public boolean verify(Double sum) throws IllegalStateException{
        if (sum > client.getBalance()){
          return false;
        }
        return true;
    }
}
