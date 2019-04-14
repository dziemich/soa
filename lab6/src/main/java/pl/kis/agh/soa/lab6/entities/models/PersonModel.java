package pl.kis.agh.soa.lab6.entities.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonModel extends Model {
  @Column(name = "first_name", nullable = false)
  String firstName;
  @Column(name = "last_name", nullable = false)
  String lastName;

  public PersonModel() {
  }

  public PersonModel(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
