package com.java.spring.study.service;

import java.util.ArrayList;
import java.util.List;

import com.java.spring.study.domain.User;
// import com.java.spring.study.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // @Autowired
    // private UserRepository repository;
    
    private List<User> list = new ArrayList<>();

    public UserService() {
        System.out.println("Create Service Layer");
        list.add(new User("user2", 2, "user2@test.com"));
        list.add(new User("user3", 3, "user3@test.com"));
    }

    // return all user
    public List<User> getAllUsers() {
        return list;
    }

    // get
    public User getUser (int id) {
        for (User u : list) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    // set
    public void setUser (User user) {
        this.list.add(user);
    }

    // update
    public void updateUser (User user) {
        for (User u : list) {
            if (u.getId() == user.getId()) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
            }
        }
    }

    //delete
    public void deleteUser (int id) {
        for (User u : list) {
            if (u.getId() == id) {
                list.remove(u);
            }
        }
    }
}
