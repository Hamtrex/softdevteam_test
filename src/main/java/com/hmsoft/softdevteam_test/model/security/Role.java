package com.hmsoft.softdevteam_test.model.security;

import com.hmsoft.softdevteam_test.model.generic.AuditedEntity;

import javax.persistence.*;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "role", schema = "security")
public class Role extends AuditedEntity {

    @Id
    @SequenceGenerator(name = "seq_role_generator", sequenceName = "seq_role", schema = "security", allocationSize = 1)
    @GeneratedValue(generator = "seq_role_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    public Role() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
