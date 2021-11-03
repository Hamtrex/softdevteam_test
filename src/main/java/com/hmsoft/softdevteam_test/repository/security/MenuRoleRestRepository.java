package com.hmsoft.softdevteam_test.repository.security;

import com.hmsoft.softdevteam_test.model.security.MenuRole;
import com.hmsoft.softdevteam_test.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author hasson_medrano
 */
@RepositoryRestResource(path = "menuRole")
public interface MenuRoleRestRepository extends JpaRepository<MenuRole, Long> {

    List<MenuRole> findByRoleAndActiveIsTrue(Role role);
}
