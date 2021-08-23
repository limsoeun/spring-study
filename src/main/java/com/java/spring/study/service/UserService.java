package com.java.spring.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java.spring.study.domain.User;
import com.java.spring.study.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    private List<User> list = new ArrayList<>();

    public UserService() {
        System.out.println("repository");
    }

    // return all user
    public List<User> getAllUsers() {
        return list;
    }

    // get
    // public User getUser (String uuid) {
    //     for (User u : list) {
    //         if (u.getUuid() == uuid) {
    //             return u;
    //         }
    //     }
    //     return null;
    // }
    public Optional<User> getUser (String uuid) {
        return repository.findById(uuid);
    }

    // set
    public void setUser (User user) {
        this.list.add(user);
    }

    // update
    public void updateUser (User user) {
        for (User u : list) {
            if (u.getUuid() == user.getUuid()) {
                u.setName(user.getName());
                u.setPassword(user.getPassword());
            }
        }
    }

    //delete
    public void deleteUser (String uuid) {
        for (User u : list) {
            if (u.getUuid() == uuid) {
                list.remove(u);
            }
        }
    }
}
