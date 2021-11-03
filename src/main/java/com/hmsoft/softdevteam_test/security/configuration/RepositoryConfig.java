package com.hmsoft.softdevteam_test.security.configuration;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import com.hmsoft.softdevteam_test.model.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * @author hasson_medrano
 */
@Configuration
class RestConfiguration implements RepositoryRestConfigurer {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurer() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//                config.setBasePath("/softdevteam_test");
                config.exposeIdsFor(
                        // Administrative
                        Person.class,
                        // Security
                        Menu.class,
                        MenuRole.class,
                        Role.class,
                        User.class,
                        UserPassword.class,
                        UserRole.class
                );
            }
        };
    }
}