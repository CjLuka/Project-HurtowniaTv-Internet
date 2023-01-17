package com.example.Projekt.hurtownia.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Projekt.hurtownia.Tabele.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
  
}
