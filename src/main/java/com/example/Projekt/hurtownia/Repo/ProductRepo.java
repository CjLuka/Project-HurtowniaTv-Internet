package com.example.Projekt.hurtownia.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Projekt.hurtownia.Tabele.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
  Product findByIdIs(Integer id);
  
}
