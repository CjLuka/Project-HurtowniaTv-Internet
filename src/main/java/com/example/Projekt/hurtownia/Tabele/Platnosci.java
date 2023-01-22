package com.example.Projekt.hurtownia.Tabele;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.bytebuddy.asm.Advice.Local;

@Entity
public class Platnosci {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id; 
  private double price;
  @ManyToOne
  private Zamowienia zamowienia;
  private LocalDate DataOd =LocalDate.now();
  private LocalDate DataDo = LocalDate.now().plusDays(30);
  @ManyToOne
  private Product product;

  public Platnosci(double price, Zamowienia zamowienia) {
    this.price = price;
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
  public Zamowienia getZamowienia() {
    return zamowienia;
  }
  public void setZamowienia(Zamowienia zamowienia) {
    this.zamowienia = zamowienia;
  }
 
  
  public Platnosci(){
    
  }
public static void getCurrentTimeUsingDate() {
  LocalDate localDate = LocalDate.now();
  System.out.println("Current time "+ localDate);
}
public LocalDate getDataOd() {
  return DataOd;
}
public void setDataOd(LocalDate dataOd) {
  DataOd = dataOd;
}
public LocalDate getDataDo() {
  return DataDo;
}
public void setDataDo(LocalDate dataDo) {
  DataDo = dataDo;
}
public Product getProduct() {
  return product;
}
public void setProduct(Product product) {
  this.product = product;
}


}
