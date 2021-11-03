package com.hmsoft.softdevteam_test.model.request;

import com.hmsoft.softdevteam_test.model.administrative.Person;

import java.io.Serializable;

/**
 * @author hasson_medrano
 */
public class NewUserRequest implements Serializable {

    private Person person;
    private String password;

    public NewUserRequest() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
