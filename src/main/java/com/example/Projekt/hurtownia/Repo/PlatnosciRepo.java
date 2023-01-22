package com.example.Projekt.hurtownia.Repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Projekt.hurtownia.Tabele.Platnosci;
import com.example.Projekt.hurtownia.Tabele.Product;

import antlr.collections.List;

public interface PlatnosciRepo extends JpaRepository<Platnosci, Integer> {
  // @Query("Select id, Price from Product inner join Platnosci on Product.id = Platnosci.product where current_timestamp() > Platnosci.DataDo")
  // ArrayList<Product> FindBySqlQuery1();

}
