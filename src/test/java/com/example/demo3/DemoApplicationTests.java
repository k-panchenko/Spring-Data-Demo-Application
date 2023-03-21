package com.example.demo3;

import com.example.demo3.entity.Person;
import com.example.demo3.validator.PersonValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

class DemoApplicationTests extends BaseTest {
    @BeforeEach
    void setUp() {
        System.out.println("DemoApplicationTests setup");
    }

    @Test
    void assertMinAge() {
        var person = new Person();
        person.setAge(minAge - 1);

        var ex = Assertions.assertThrows(
                RuntimeException.class,
                () -> personValidator.validate(person)
        );

        Assertions.assertEquals("Age less than required", ex.getMessage());
    }

    @Test
    void assertMaxAge() {
        var person = new Person();
        person.setAge(maxAge + 1);

        var ex = Assertions.assertThrows(
                RuntimeException.class,
                () -> personValidator.validate(person)
        );

        Assertions.assertEquals("Age greater than max", ex.getMessage());
    }
}
