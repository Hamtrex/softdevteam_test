package com.hmsoft.softdevteam_test.repository.administrative;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author hasson_medrano
 */
@RepositoryRestResource(path = "person")
public interface PersonRestRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByPersonalId(Long personalId);
}
