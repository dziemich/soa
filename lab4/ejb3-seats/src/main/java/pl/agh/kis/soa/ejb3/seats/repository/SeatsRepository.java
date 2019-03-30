package pl.agh.kis.soa.ejb3.seats.repository;

import pl.agh.kis.soa.ejb3.seats.model.Seat;
import java.util.List;

public class SeatsRepository {
  public static List<Seat> get(){
    return List.of(
        new Seat(1, "A", false, 20.0, false),
        new Seat(1, "B", false, 20.0, false),
        new Seat(1, "C", false, 20.0, false),
        new Seat(1, "D", false, 20.0, false),
        new Seat(1, "E", false, 20.0, false),
        new Seat(1, "F", false, 20.0, false),
        new Seat(2, "A", false, 50.0, false),
        new Seat(2, "B", false, 50.0, false),
        new Seat(2, "C", false, 50.0, false),
        new Seat(2, "D", false, 50.0, false),
        new Seat(2, "E", false, 50.0, false),
        new Seat(2, "F", false, 50.0, false)
    );
  }
}
