package com.hmsoft.softdevteam_test.model.security;

import com.hmsoft.softdevteam_test.model.generic.AuditedEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "menu", schema = "security")
public class Menu extends AuditedEntity {

    @Id
    @SequenceGenerator(name = "seq_menu_generator", sequenceName = "seq_menu", schema = "security", allocationSize = 1)
    @GeneratedValue(generator = "seq_menu_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "label", nullable = false)
    private String label;
    @Column(name = "path", nullable = false)
    private String path;
    @Column(name = "icon")
    private String icon;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "root", nullable = false)
    private Boolean root;
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "parent")
    private List<Menu> children;
    @OneToOne
    @JoinColumn(name = "parent")
    private Menu parent;

    public Menu() {}

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRoot() {
        return this.root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public List<Menu> getChildren() {
        return this.children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
