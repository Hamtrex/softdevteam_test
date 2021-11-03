package com.hmsoft.softdevteam_test.model.request;

import java.io.Serializable;

/**
 * @author hasson_medrano
 */
public class UserRequest implements Serializable {

    private String name;
    private String password;

    public UserRequest() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPasswrod(String password) {
        this.password = password;
    }
}
