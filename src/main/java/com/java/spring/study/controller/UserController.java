package com.java.spring.study.controller;

import java.util.List;

import com.java.spring.study.domain.User;
import com.java.spring.study.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(value = HttpStatus.OK)
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/api/user/all")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @PostMapping("/api/user")
    public User postUser(@RequestBody User user) {
        service.setUser(user);
        return user;
    }

    @PutMapping("/api/user")
    public User putUser(@RequestBody User user) {
        service.updateUser(user);
        return user;
    }

    @DeleteMapping("/api/user/{id}")
    public User deleteUser(@PathVariable int id) {
        User delete = service.getUser(id);
        service.deleteUser(id);
        return delete;
    }
}
