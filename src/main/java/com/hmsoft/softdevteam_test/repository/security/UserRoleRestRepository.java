package com.hmsoft.softdevteam_test.repository.security;

import com.hmsoft.softdevteam_test.model.security.User;
import com.hmsoft.softdevteam_test.model.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * @author hasson_medrano
 */
@RepositoryRestResource(path = "userRole")
public interface UserRoleRestRepository extends JpaRepository<UserRole, Long> {

    Optional<List<UserRole>> findByUser(User user);
}
