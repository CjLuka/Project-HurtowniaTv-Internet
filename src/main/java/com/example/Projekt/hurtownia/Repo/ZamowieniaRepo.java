package com.example.Projekt.hurtownia.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Projekt.hurtownia.Tabele.Zamowienia;

public interface ZamowieniaRepo extends JpaRepository<Zamowienia, Integer> {
  
}
