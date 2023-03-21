package com.example.demo3.validator;

import com.example.demo3.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdultValidator implements PersonValidator {
    @Value("${age.min}")
    private Integer minAge;

    @Value("${age.max}")
    private Integer maxAge;

    @Override
    public void validate(Person person) {
        var age = person.getAge();

        if (age < minAge) throw new RuntimeException("Age less than required");

        if (age > maxAge) throw new RuntimeException("Age greater than max");
    }
}
