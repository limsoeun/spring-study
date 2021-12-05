package com.java.spring.study.repository;

import com.java.spring.study.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Query(value = "insert into user values (:#{#paramUser.uuid}, :#{#paramUser.user_id}, :#{#paramUser.name}, :#{#paramUser.password})", nativeQuery = true)
    @Transactional
    public void insertUser(@Param(value = "paramUser") User user);
}
