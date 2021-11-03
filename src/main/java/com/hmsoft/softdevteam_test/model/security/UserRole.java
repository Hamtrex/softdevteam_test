package com.hmsoft.softdevteam_test.model.security;

import javax.persistence.*;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "user_role", schema = "security")
public class UserRole {

    @Id
    @SequenceGenerator(name = "seq_userRole_generator", sequenceName = "seq_user_role", schema = "security", allocationSize = 1)
    @GeneratedValue(generator = "seq_userRole_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    private Role role;
    @Column(name = "observations")
    private String observations;

    public UserRole() {}

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
