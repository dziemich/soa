package pl.agh.kis.soa.ejb3.seats.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import pl.agh.kis.soa.ejb3.seats.model.Seat;
import pl.agh.kis.soa.ejb3.seats.repository.SeatsRepository;

@Singleton
public class SeatsController {
    List<Seat> seats;
    @PostConstruct
    public void init(){
        seats =  SeatsRepository.get();
    }

    @Lock(LockType.WRITE)
    private void buyTicket(Seat seat){
        seat.setTaken(true);
    }

    @Lock(LockType.READ)
    public List<Seat> getSeatList(){
       return seats;
    }

    public Double getSeatPrice(Seat seat){
        return seat.getPrice();
    }

    public Double buyTickets(){
        return marksSeatsAsTakenAndCollectMoney();
    }


    private Double marksSeatsAsTakenAndCollectMoney(){
        return seats
            .stream()
            .filter(Seat::getSelected)
            .peek(this::buyTicket)
            .map(Seat::getPrice)
            .mapToDouble(Double::doubleValue)
            .sum();
    }
}
