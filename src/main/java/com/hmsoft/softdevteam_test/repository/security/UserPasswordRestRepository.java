package com.hmsoft.softdevteam_test.repository.security;

import com.hmsoft.softdevteam_test.model.security.User;
import com.hmsoft.softdevteam_test.model.security.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author hasson_medrano
 */
@RepositoryRestResource(path = "userPassword")
public interface UserPasswordRestRepository extends JpaRepository<UserPassword, Long> {
    Optional<UserPassword> findByUserAndActiveIsTrue(User user);
}
