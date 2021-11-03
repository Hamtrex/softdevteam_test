package com.hmsoft.softdevteam_test.model.security;

import com.hmsoft.softdevteam_test.model.administrative.Person;
import com.hmsoft.softdevteam_test.model.generic.AuditedEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "user", schema = "security")
public class User extends AuditedEntity {

    @Id
    @SequenceGenerator(name = "seq_user_generator", sequenceName = "seq_user", schema = "security", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "person", referencedColumnName = "id", nullable = false)
    private Person person;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "observations")
    private String observations;
    @OneToMany
    @JoinTable(
            name = "user_role",
            schema = "security",
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role", referencedColumnName = "id")}
    )
    private List<Role> roles;

    public User() {}

    public User(Person person, String name, String observations) {
        this.person = person;
        this.name = name;
        this.observations = observations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
