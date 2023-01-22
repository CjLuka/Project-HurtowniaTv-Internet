package com.example.Projekt.hurtownia.Tabele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Id;
  private String FirstName;
  private String SecondName;
  @Column(unique = true)
  private String Email;
  private String Rola;
  private String Password;
  //@OneToMany(mappedBy = "person")
  //private List<Zamowienia> personId = new ArrayList<Zamowienia>();

  

  public Person(String firstName, String secondName, String email, String rola, String password) {
    FirstName = firstName;
    SecondName = secondName;
    Email = email;
    Rola = rola;
    Password = password;
  }
  public Person() {
  }
  
  public Integer getId() {
    return Id;
  }
  public void setId(Integer id) {
    Id = id;
  }
  //public List<Zamowienia> getPersonId() {
  //  return personId;
  //}
  //public void setPersonId(List<Zamowienia> personId) {
  //  this.personId = personId;
  //}
  public String getFirstName() {
    return FirstName;
  }
  public void setFirstName(String firstName) {
    FirstName = firstName;
  }
  public String getSecondName() {
    return SecondName;
  }
  public void setSecondName(String secondName) {
    SecondName = secondName;
  }
  public String getEmail() {
    return Email;
  }
  public void setEmail(String email) {
    Email = email;
  }
  public String getRola() {
    return Rola;
  }
  public void setRola(String rola) {
    Rola = rola;
  }
  public String getPassword() {
    return Password;
  }
  public void setPassword(String password) {
    Password = password;
  }
  

  
  

}
