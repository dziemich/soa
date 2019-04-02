package pl.agh.kis.soa.ejb3.seats.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import pl.agh.kis.soa.ejb3.commons.model.Seat;
import pl.agh.kis.soa.ejb3.commons.repository.SeatsRepository;

@Singleton
public class SeatsController {
    List<Seat> seats;
    @PostConstruct
    public void init(){
        seats =  SeatsRepository.get();
    }

    @Lock(LockType.WRITE)
    private boolean buyTicket(Seat seat){
        if(seat.getTaken()) return false;
        seat.setTaken(true);
        return true;
    }

    @Lock(LockType.READ)
    public List<Seat> getSeatList(){
       return seats;
    }

    public Double getSeatPrice(Seat seat){
        return seat.getPrice();
    }

    public Double calculateTicketPrice(){
        return seats
            .stream()
            .filter(Seat::getSelected)
            .map(Seat::getPrice)
            .mapToDouble(Double::doubleValue)
            .sum();

    }

    public void markSeatsAsTaken(){
        seats
            .stream()
            .filter(Seat::getSelected)
            .peek(this::buyTicket)
            .peek(seat -> seat.setSelected(false))
        .collect(Collectors.toList());
    }
}
