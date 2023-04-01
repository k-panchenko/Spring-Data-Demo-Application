package com.example.democlient;

import com.example.democlient.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoClientApplication implements CommandLineRunner {

    @Autowired
    WebClient webClient;


    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        var response = webClient.get()
                .uri("http://localhost:8080/people/2")
                .retrieve()
                .bodyToMono(Person.class)
                .block();

        Stream.of().forEach(o -> System.out.println(o));

        System.out.println(response);
    }
}
