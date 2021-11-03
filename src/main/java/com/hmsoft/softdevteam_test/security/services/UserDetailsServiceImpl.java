package com.hmsoft.softdevteam_test.security.services;

import com.hmsoft.softdevteam_test.model.security.User;
import com.hmsoft.softdevteam_test.model.security.UserPassword;
import com.hmsoft.softdevteam_test.repository.security.UserPasswordRestRepository;
import com.hmsoft.softdevteam_test.repository.security.UserRestRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @author hasson
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRestRepository userRestRepository;
    private UserPasswordRestRepository userPasswordRestRepository;

    public UserDetailsServiceImpl(
            UserRestRepository userRestRepository,
            UserPasswordRestRepository userPasswordRestRepository
    ) {
        this.userRestRepository = userRestRepository;
        this.userPasswordRestRepository = userPasswordRestRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRestRepository.findByName(name);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Optional<UserPassword> optionalUserPassword = this.userPasswordRestRepository.findByUserAndActiveIsTrue(user);
            if (optionalUserPassword.isPresent()) {
                return new org.springframework.security.core.userdetails.User(
                        user.getName(),
                        optionalUserPassword.get().getPassword(),
                        Collections.emptyList()
                );
            } else {
                throw new UsernameNotFoundException(name);
            }
        } else {
            throw new UsernameNotFoundException(name);
        }
    }
}
