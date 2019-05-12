package pl.kis.agh.soa.entities.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonModel extends Model {
  @Column(name = "first_name", nullable = false)
  String firstName;
  @Column(name = "last_name", nullable = false)
  String lastName;
  @Column(name = "age", nullable = false)
  Integer age;

  public String getFullName(){
    return String.format("%s %s", this.getFirstName(), this.getLastName());
  }

  public PersonModel(){}

  public PersonModel(PersonModel pm){
    this.firstName = pm.firstName;
    this.lastName = pm.lastName;
    this.age = pm.age;
  }

  public PersonModel(String firstName, String lastName, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
