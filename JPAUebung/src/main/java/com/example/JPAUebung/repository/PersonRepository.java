package com.example.JPAUebung.repository;

import com.example.JPAUebung.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}

