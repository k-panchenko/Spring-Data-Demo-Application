package com.example.demo3.repository;

import com.example.demo3.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> getPersonByEmailContains(String email);
}
