package com.example.Projekt.hurtownia.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Projekt.hurtownia.Tabele.Platnosci;

public interface PlatnosciRepo extends JpaRepository<Platnosci, Integer> {
  
}
