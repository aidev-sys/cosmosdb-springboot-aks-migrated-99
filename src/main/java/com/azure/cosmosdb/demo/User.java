package com.azure.cosmosdb.demo;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "city")
    private String city;

    public User() {

    }

    public User(String email, String firstName, String lastName, String city) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", city=" + city + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}