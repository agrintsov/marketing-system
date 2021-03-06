package com.sagr.marketing.system.user;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author AGrintsov
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Integer id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="organisation")
    private String organisation;
    @Column(name="login")
    private String login;
    @Column(name="passwordHash")
    private String passwordHash;

    public User() {}

    public User(String firstName, String lastName, String organisation, String login, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.organisation = organisation;
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
}
