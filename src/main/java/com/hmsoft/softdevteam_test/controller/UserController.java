package com.hmsoft.softdevteam_test.controller;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import com.hmsoft.softdevteam_test.model.request.NewUserRequest;
import com.hmsoft.softdevteam_test.model.request.UserRequest;
import com.hmsoft.softdevteam_test.model.security.User;
import com.hmsoft.softdevteam_test.model.security.UserPassword;
import com.hmsoft.softdevteam_test.repository.administrative.PersonRestRepository;
import com.hmsoft.softdevteam_test.repository.security.UserPasswordRestRepository;
import com.hmsoft.softdevteam_test.repository.security.UserRestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author hasson
 */
@RestController
@RequestMapping("userController")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRestRepository userRestRepository;
    private PersonRestRepository personRestRepository;
    private UserPasswordRestRepository userPasswordRestRepository;

    public UserController(
            BCryptPasswordEncoder bCryptPasswordEncoder,
            UserRestRepository userRestRepository,
            PersonRestRepository personRestRepository,
            UserPasswordRestRepository userPasswordRestRepository
    ) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRestRepository = userRestRepository;
        this.personRestRepository = personRestRepository;
        this.userPasswordRestRepository = userPasswordRestRepository;
    }

    @PostMapping(path = "/generatePassword")
    public ResponseEntity<String> generatePassword(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(this.bCryptPasswordEncoder.encode(userRequest.getPassword()), HttpStatus.ACCEPTED) ;
    }

    @GetMapping(path = "/me")
    public ResponseEntity<User> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> optionalUser = this.userRestRepository.findByName(authentication.getName());
        if (optionalUser.isPresent()) {
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.FOUND);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    @Transactional
    @PostMapping(path = "/create")
    public ResponseEntity<User> create(@RequestBody NewUserRequest newUserRequest) {
        try {
            Person person = this.personRestRepository.save(
                    newUserRequest.getPerson()
            );
            User user = this.userRestRepository.save(
                    new User(person, person.getEmail(), "New User By Application")
            );
            UserPassword userPassword = new UserPassword(user, this.bCryptPasswordEncoder.encode(newUserRequest.getPassword()));
            this.userPasswordRestRepository.save(userPassword);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
        }
    }
}
