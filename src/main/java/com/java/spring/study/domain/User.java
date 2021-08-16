package com.java.spring.study.domain;

public class User {
    private String name;
    private int id;
    private String email;

    public User (String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString () {
        return "User [name=" + name + ", id=" + id + ", email=" + email + "]";
    }
}