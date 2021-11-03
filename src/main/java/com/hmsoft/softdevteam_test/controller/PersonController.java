package com.hmsoft.softdevteam_test.controller;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import com.hmsoft.softdevteam_test.repository.administrative.PersonRestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author hasson_medrano
 */
@RestController
@RequestMapping("personController")
public class PersonController {

    private PersonRestRepository personRestRepository;

    public PersonController(
            PersonRestRepository personRestRepository
    ) {
        this.personRestRepository = personRestRepository;
    }

    @PutMapping(path = "deleteByPersonalId/{personalId}")
    ResponseEntity<Person> deleteByPersonalId(@PathVariable Long personalId) {
        try {
            Optional<Person> optionalPerson = this.personRestRepository.findByPersonalId(personalId);
            if (optionalPerson.isPresent()) {
                Person person = optionalPerson.get();
                person.setActive(false);
                this.personRestRepository.save(person);
                return new ResponseEntity<>(person, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
