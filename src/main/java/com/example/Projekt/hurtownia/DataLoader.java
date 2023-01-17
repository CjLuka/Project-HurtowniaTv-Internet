package com.example.Projekt.hurtownia;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Projekt.hurtownia.Repo.PersonRepo;
import com.example.Projekt.hurtownia.Repo.PlatnosciRepo;
import com.example.Projekt.hurtownia.Repo.ProductRepo;
import com.example.Projekt.hurtownia.Repo.ZamowieniaRepo;
//import com.example.Projekt.hurtownia.Tabele.Package;
//import com.example.Projekt.hurtownia.Tabele.PackageProducts;
import com.example.Projekt.hurtownia.Tabele.Person;
import com.example.Projekt.hurtownia.Tabele.Product;

@Component
public class DataLoader {

	private PersonRepo personRepo;
  private PlatnosciRepo platnosciRepo;
	private ProductRepo productRepo;
  private ZamowieniaRepo zamowieniaRepo;
	@Autowired
  public DataLoader(PersonRepo personRepo,PlatnosciRepo platnosciRepo,ProductRepo productRepo,ZamowieniaRepo zamowieniaRepo){
    
    this.personRepo = personRepo;
    this.platnosciRepo = platnosciRepo;
    this.productRepo = productRepo;
    this.zamowieniaRepo = zamowieniaRepo;

    //Tworzenie uzytkownikow
    //Person person1 = new Person("Jan", "Kowalski", "jan.kowal@o2.pl", "gosc", "gosc");
    //Person person2 = new Person("Tomasz", "Nowak", "tom.nowak@o2.pl", "gosc", "gosc");
    //Person person3 = new Person("Lukasz", "Swinicki", "lukasz.sw@o2.pl", "admin", "admin");
    //personRepo.save(person1);
    //personRepo.save(person2);
    //personRepo.save(person3);
    ////Tworzenie produktow
    //Product product1 = new Product("Internet 20gb", 50.00);
    //Product product2 = new Product("Internet 40gb", 100.00);
    //Product product3 = new Product("Tv - 100 kanalow", 25.00);
    //Product product4 = new Product("Tv - 200 kanalow", 50.00);
    //productRepo.save(product1);
    //productRepo.save(product2);
    //productRepo.save(product3);
    //productRepo.save(product4);
    //Tworzenie pakietow
    //Package package1 = new Package("20gb internetu i 100 kanalow", 65.00);
    //Package package2 = new Package("40gb internetu i 200 kanalow", 120.00);
    //packageRepo.save(package1);
    //packageRepo.save(package2);
    ////Tworzenie pakietow
    //PackageProducts packageProducts1 = new PackageProducts(package1, product1);
    //PackageProducts packageProducts2 = new PackageProducts(package2, product2);
    //packageProductRepo.save(packageProducts1);
    //packageProductRepo.save(packageProducts2);
    //PackageProducts packageProducts3 = new PackageProducts(package1, product2);
  }
}
