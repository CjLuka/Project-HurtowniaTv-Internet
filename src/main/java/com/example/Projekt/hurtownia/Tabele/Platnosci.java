package com.example.Projekt.hurtownia.Tabele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Platnosci {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id; 
  private double price;
  @ManyToOne
  private Person person;
  @ManyToOne
  private Zamowienia zamowienia;


  public Platnosci(){
    
  }

  
  public Platnosci(double price, Person person, Zamowienia zamowienia) {
    this.price = price;
    this.person = person;
    this.zamowienia = zamowienia;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public Person getPerson() {
    return person;
  }
  public void setPerson(Person person) {
    this.person = person;
  }
  public Zamowienia getZamowienia() {
    return zamowienia;
  }
  public void setZamowienia(Zamowienia zamowienia) {
    this.zamowienia = zamowienia;
  }

  
}
