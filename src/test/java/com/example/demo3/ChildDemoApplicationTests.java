package com.example.demo3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChildDemoApplicationTests extends DemoApplicationTests {
    @BeforeEach
    void setUp2() {
        System.out.println("ChildDemoApplicationTests setup");
    }

    @Test
    void someTest() {

    }
}
