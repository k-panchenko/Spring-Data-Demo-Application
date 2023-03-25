package com.cbs.springcourse.rest.controllers;

import com.cbs.springcourse.rest.models.Error;
import com.cbs.springcourse.rest.models.Person;
import com.cbs.springcourse.rest.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController // @Controller + @ResponseBody над кожним методом
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT})
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертує ці об'єкти у JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id); // Jackson конвертує у JSON
    }

    @PutMapping()
    public ResponseEntity<?> savePerson(RequestEntity<Person> entity) {
        var person = entity.getBody();
        var existed = peopleService.findOne(person.getId());

        if (existed != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        peopleService.create(person);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Error handler(NoSuchElementException exception) {
        return new Error(List.of("User not found"));
    }
}
