package com.iiitn.foodcourt.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false , updatable = false)
    private int id;
    private String username;
    private  String password;
    private  String email;
    @OneToOne
    private Profile profile;

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User(String username, String password, String email) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {

    }
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public Profile getProfile() {
        return profile;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
    }
}
