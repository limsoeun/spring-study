package com.java.spring.study.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.java.spring.study.domain.User;
import com.java.spring.study.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/test")
    public User test(@RequestBody User u) {
        return service.testService(u);
    }

    @GetMapping("/api/user/all")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/api/user")
    public Optional<User> getUser(@PathParam("uuid") String uuid) {
        return service.getUser(uuid);
    }

    @PostMapping("/api/user")
    public User postUser(@RequestBody User user) {
        return service.setUser(user);
    }

    @PutMapping("/api/user")
    public Optional<User> putUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/api/user")
    public void deleteUser(@PathParam("uuid") String uuid) {
        service.deleteUser(uuid);
    }
}
