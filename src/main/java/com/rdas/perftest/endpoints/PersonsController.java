package com.rdas.perftest.endpoints;

import com.rdas.perftest.model.Person;
import com.rdas.perftest.repositpry.PersonsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PersonsController {

    @Autowired
    private PersonsRepository repository;

    @GetMapping
    public List<Person> findAll() {
        return (List<Person>) repository.findAll();
    }

    @PostMapping
    public Person add(@RequestBody Person person) {
        Person p = repository.save(person);
        log.info("add: {}", p.toString());
        return p;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {
        log.info("findById: id={}", id);
        Optional<Person> byId = repository.findById(id);
        return byId.orElse(null);
    }
}
