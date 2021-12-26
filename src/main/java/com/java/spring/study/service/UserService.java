package com.java.spring.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    // query 어노테이션을 사용한 insert
    public User setQueryUser(User user) {
        repository.insertUser(user); // repository.save(user);
        return user;
    }

    // set
    public User setUser(User user) {
        repository.save(user); //  primaye_key 가 autoIncrement일 경우
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


    // db sync
    public List<User> syncUser() {
        List<User> userList = repository.findAll(); // 등록된 사용자 목록
        List<User> addList = new ArrayList<User>(); // 추가될 db 사용자 목록

        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        u1.setUuid("124afs331");
        u2.setUuid("sdgk38efuwk3");
        u3.setUuid("4reruu5331");
        u4.setUuid("54d2af4s1");
        addList.add(u1);
        addList.add(u2);
        addList.add(u3);
        addList.add(u4);

        List<User> newList = addList.stream().filter(item -> 
            userList.stream().map(el -> el.getUuid()).collect(Collectors.toList()).indexOf(item.getUuid()) == -1 
            ).collect(Collectors.toList()); // object list

        List<User> updateList = addList.stream().filter(item -> 
            userList.stream().map(el -> el.getUuid()).collect(Collectors.toList()).indexOf(item.getUuid()) != -1 
            ).collect(Collectors.toList()); // object list

        List<String> deleteList = userList.stream().filter(item -> 
            addList.stream().map(el -> el.getUuid()).collect(Collectors.toList()).indexOf(item.getUuid()) == -1 
            ).collect(Collectors.toList()).stream().map(el -> el.getUuid()).collect(Collectors.toList()); // id list


        if (newList.size() > 0) {
            // bulk add api 호출
            System.out.println("bulk add!!");
            System.out.println(newList);
        }
        if (updateList.size() > 0) {
            // bulk update api 호출
            System.out.println("bulk update!!");
            System.out.println(updateList);
        }
        if (deleteList.size() > 0) {
            // bulk delete api 호출
            System.out.println("bulk delete!!");
            System.out.println(deleteList);
        }
        
        return addList;
    }
}
