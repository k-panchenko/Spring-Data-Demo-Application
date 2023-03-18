package com.example.demo3.repository;

import com.example.demo3.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> getPersonByEmailContains(String email);
}
