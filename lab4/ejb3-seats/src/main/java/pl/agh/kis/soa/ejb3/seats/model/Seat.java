package pl.agh.kis.soa.ejb3.seats.model;

import java.util.Objects;

public class Seat {
  private Integer row;
  private String place;
  private Boolean taken;
  private Double price;
  private Boolean selected;

  public Seat(Integer row, String place, Boolean taken, Double price, Boolean selected) {
    this.row = row;
    this.place = place;
    this.taken = taken;
    this.price = price;
    this.selected = selected;
  }

  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public Boolean getTaken() {
    return taken;
  }

  public void setTaken(Boolean taken) {
    this.taken = taken;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean selected) {
    this.selected = selected;
  }
}
