package com.example.Projekt.hurtownia.Tabele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Zamowienia {
  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer Id;
  private double price;
  @ManyToOne
  //@JoinColumn(name = "PersonId")
  private Person person;
  @ManyToOne
  private Product product;
  private Integer IdProductu;
  public Integer getIdProductu() {
    return IdProductu;
  }

  public void setIdProductu(Integer idProductu) {
    IdProductu = idProductu;
  }

  //@OneToMany(mappedBy = "zamowienia")
  //private List<Platnosci> zamowienieId = new ArrayList<Platnosci>();
  public Integer getId() {
    return Id;
  }
  
  

  public void setId(Integer id) {
    Id = id;
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
  
 // public List<Platnosci> getZamowienieId() {
 //   return zamowienieId;
 // }
 // public void setZamowienieId(List<Platnosci> zamowienieId) {
 //   this.zamowienieId = zamowienieId;
 // }
   public Zamowienia() {
  }
  public Zamowienia(double price,Integer id) {
    this.price = price;
    //this.person = person;
    this.IdProductu = id;
  }

  public Zamowienia(double price, Product product) {
    this.price = price;
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
  
 

}
