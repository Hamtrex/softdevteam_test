package com.hmsoft.softdevteam_test.model.administrative;

import com.hmsoft.softdevteam_test.model.generic.AuditedEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hasson_medrano
 */
@Entity
@Table(name = "person", schema = "administrative")
public class Person extends AuditedEntity {

    @Id
    @SequenceGenerator(name = "seq_person_generator", sequenceName = "seq_person", schema = "administrative", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "first_surname", nullable = false)
    private String firstSurname;
    @Column(name = "second_surname")
    private String secondSurname;
    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "personal_id", nullable = false, unique = true)
    private Long personalId;
    @Column(name = "tax_id", unique = true)
    private Long taxId;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone")
    private String phone;

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Long personalId) {
        this.personalId = personalId;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
