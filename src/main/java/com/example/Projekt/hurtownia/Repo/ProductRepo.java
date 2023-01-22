package com.example.Projekt.hurtownia.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Projekt.hurtownia.Tabele.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
  Product findByIdIs(Integer id);
  Product findByIdNotIn(List<Integer> List);

  @Query(value = "Select Product.id from Product inner join Platnosci on Product.Id = Platnosci.product_id where current_timestamp() < Platnosci.Data_Do", nativeQuery = true)
  List<Integer> FindBySqlQuery1();
}
