package com.java.spring.study.controller;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping("/api/user/all")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/api/user/{uuid}")
    public Optional<User> getUser(@PathVariable String uuid) {
        return service.getUser(uuid);
    }

    // @GetMapping("/api/user/{uuid}")
    // public String getUser(@PathVariable String uuid) {
    //     String result = "";
    //     for (User user : repository.findByUuid(uuid)) {
    //         result += user.toString();
    //     }
    //     return result;
    // }

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

    @DeleteMapping("/api/user/{uuid}")
    public void deleteUser(@PathVariable String uuid) {
        service.deleteUser(uuid);
    }
}
