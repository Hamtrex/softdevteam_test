package com.hmsoft.softdevteam_test.repository.security;

import com.hmsoft.softdevteam_test.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author hasson
 */
@RepositoryRestResource(path = "user")
public interface UserRestRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
