package com.example.demo3;

import com.example.demo3.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTest {
    @Autowired
    protected PersonValidator personValidator;

    @Value("${age.min}")
    protected Integer minAge;

    @Value("${age.max}")
    protected Integer maxAge;
}
