package com.hmsoft.softdevteam_test.repository.security;

import com.hmsoft.softdevteam_test.model.security.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author hasson_medrano
 */
@RepositoryRestResource(path = "menu")
public interface MenuRestRepository extends JpaRepository<Menu, Long> {

    // Root Active Menus
    List<Menu> findByActiveIsTrueAndTypeEquals(String type);
}
