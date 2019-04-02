package pl.agh.kis.soa.ejb3.seats;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import pl.agh.kis.soa.ejb3.commons.exception.CustomISException;
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

    public boolean verify(Double sum) throws CustomISException {
        if (sum > client.getBalance()){
            throw new CustomISException("not enough money");
//          return false;
        }
        return true;
    }
}
