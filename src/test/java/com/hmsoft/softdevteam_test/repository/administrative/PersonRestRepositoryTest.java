package com.hmsoft.softdevteam_test.repository.administrative;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonRestRepositoryTest {

    @Mock
    private PersonRestRepository personRestRepository;

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
        person.setActive(true);
        person.setCreatedAt(new Date());
        person.setCreatedBy("TEST USER");
        person.setVersion(1);
    }

    @Test
    void findAll() {
        when(personRestRepository.findAll()).thenReturn(List.of(person));
        assertNotNull(personRestRepository.findAll());
    }

    @Test
    void findByPersonalId() {
        when(personRestRepository.findByPersonalId(any(Long.class))).thenReturn(Optional.ofNullable(person));
        assertNotNull(personRestRepository.findByPersonalId(1L));
    }
}