package com.hmsoft.softdevteam_test.repository.security;

import com.hmsoft.softdevteam_test.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author hasson_medrano
 */
@RepositoryRestResource(path = "role")
public interface RoleRestRepository extends JpaRepository<Role, Long> {
}
