package com.example.demo3;

import com.example.demo3.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class DemoApplicationTests extends BaseTest {

    @BeforeEach
    void setUp() {
        System.out.println("DemoApplicationTests setup");
    }

    @Test
    void assertMinAge() {
        var person = new Person();
        person.setAge(minAge - 1);

        when(personRepository.getReferenceById(anyInt()))
                .thenReturn(person);

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

        when(personRepository.getReferenceById(anyInt()))
                .thenReturn(person);

        var ex = Assertions.assertThrows(
                RuntimeException.class,
                () -> personValidator.validate(person)
        );

        Assertions.assertEquals("Age greater than max", ex.getMessage());
    }
}
