package com.hmsoft.softdevteam_test.model.security;

import com.hmsoft.softdevteam_test.model.generic.AuditedEntity;

import javax.persistence.*;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "menu_role", schema = "security")
public class MenuRole extends AuditedEntity {

    @Id
    @SequenceGenerator(name = "seq_menuRole_generator", sequenceName = "seq_menu_role", schema = "security", allocationSize = 1)
    @GeneratedValue(generator = "seq_menuRole_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "menu", referencedColumnName = "id", nullable = false)
    private Menu menu;
    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    private Role role;
    @Column(name = "observations")
    private String observations;

    public MenuRole() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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
