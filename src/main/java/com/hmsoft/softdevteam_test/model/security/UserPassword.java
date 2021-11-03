package com.hmsoft.softdevteam_test.model.security;

import com.hmsoft.softdevteam_test.model.generic.AuditedEntity;

import javax.persistence.*;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "user_password", schema = "security")
public class UserPassword extends AuditedEntity {

    @Id
    @SequenceGenerator(name = "seq_userPassword_generator", sequenceName = "seq_user_password", schema = "security", allocationSize = 1)
    @GeneratedValue(generator = "seq_userPassword_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;
    @Column(name = "password", nullable = false)
    private String password;

    public UserPassword() {}

    public UserPassword(User user, String password) {
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
