package com.mdstech.sample.controller;

import com.mdstech.sample.domain.Person;
import com.mdstech.sample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Srini on 4/1/17.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/sampledata")
    public void loadSampleData() {
        personService.loadSampleData();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") Long id) {
        Person person = personService.findOne(id);
        return new ResponseEntity<>(person.getName(), null, HttpStatus.OK);
    }
}
