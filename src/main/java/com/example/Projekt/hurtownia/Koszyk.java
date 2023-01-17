package com.example.Projekt.hurtownia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.example.Projekt.hurtownia.Tabele.Product;

//import com.example.Projekt.hurtownia.Tabele.Package;



@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Koszyk {
  private List<Product> zamowienie = new ArrayList<Product>();

  public boolean usunZListy(Product product){
    return zamowienie.remove(product);
  }

  public void dodajdokoszyka(Product optional){
    zamowienie.add(optional);
  }

  @Override
  public String toString() {
    return "Koszyk [zamowienie=" + zamowienie + "]";
  }

  public Koszyk(List<Product> zamowienie) {
    this.zamowienie = zamowienie;
  }

  public Koszyk() {
  }

  public List<Product> getZamowienie() {
    return zamowienie;
  }

  public void setZamowienie(List<Product> zamowienie) {
    this.zamowienie = zamowienie;
  }
  
  
}
