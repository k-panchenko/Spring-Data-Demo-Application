package com.example.demo3;

import com.example.demo3.repository.PersonRepository;
import com.example.demo3.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public abstract class BaseTest {
    @Autowired
    protected PersonValidator personValidator;
    @MockBean // Для заглушання бінів вказуйте цю аннотацію. Після цього його можна використовувати як мок
    protected PersonRepository personRepository;

    @Value("${age.min}")
    protected Integer minAge;

    @Value("${age.max}")
    protected Integer maxAge;
}
