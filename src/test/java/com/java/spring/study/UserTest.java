package com.java.spring.study;

import java.util.List;

import com.java.spring.study.domain.User;
import com.java.spring.study.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    UserRepository repository;

    @Test
    public List<User> findAll() {
        List<User> user = repository.findAll();
        return user;
    }
}
