package com.hmsoft.softdevteam_test.model.generic;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author hasson_medrano
 */
@MappedSuperclass
public class GenericCatalog extends AuditedEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

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
