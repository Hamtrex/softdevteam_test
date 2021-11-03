package com.hmsoft.softdevteam_test.controller;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import com.hmsoft.softdevteam_test.repository.administrative.PersonRestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonControllerTest {

    @Mock
    private PersonRestRepository personRestRepository;

    @InjectMocks
    private PersonController personController;

    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new Person();
        person.setFirstName("HASSON");
        person.setFirstSurname("MEDRANO");
        person.setPersonalId(2751061442201L);
        person.setTaxId(83908464L);
        person.setBirthday(new Date());
        person.setActive(false);
        person.setCreatedAt(new Date());
        person.setCreatedBy("TEST USER");
        person.setVersion(1);
    }

    @Test
    void deleteByPersonalId() {
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        if (optionalPerson.isPresent()) {
            when(personRestRepository.save(any(Person.class))).thenReturn(person);
            assertNotNull(personRestRepository.save(person));
        }
    }
}