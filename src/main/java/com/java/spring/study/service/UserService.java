package com.java.spring.study.service;

import java.util.List;
import java.util.Optional;

import com.java.spring.study.domain.User;
import com.java.spring.study.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class UserService {

    @Autowired
    private UserRepository repository;

    public User testService(User u) {
        User user = repository.save(u);
        return user;
    }

    public UserService() {
        System.out.println("service");
    }

    // return all user
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // get
    public Optional<User> getUser(String uuid) {
        return repository.findById(uuid);
    }

    // set
    public User setUser(User user) {
        repository.insertUser(user); // repository.save(user);
        return user;
    }

    // update
    public Optional<User> updateUser(User user) {
        Optional<User> updateUser = repository.findById(user.getUuid());

        updateUser.ifPresent(selectUser->{
            selectUser.setName(user.getName());
            selectUser.setPassword(user.getPassword());
            selectUser.setUser_id(user.getUser_id());
            
            repository.save(selectUser);
        });

        return updateUser;
    }

    // delete
    public void deleteUser(String uuid) {
        repository.deleteById(uuid);
    }
}
