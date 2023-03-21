package com.example.demo3.validator;

import com.example.demo3.entity.Person;
import com.example.demo3.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class AdultValidator implements PersonValidator {
    private final PersonRepository personRepository;

    @Value("${age.min}")
    private Integer minAge;

    @Value("${age.max}")
    private Integer maxAge;

    public AdultValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void validate(Person person) {
        person = personRepository.getReferenceById(1);

        var age = person.getAge();

        if (age < minAge) throw new RuntimeException("Age less than required");

        if (age > maxAge) throw new RuntimeException("Age greater than max");
    }
}
