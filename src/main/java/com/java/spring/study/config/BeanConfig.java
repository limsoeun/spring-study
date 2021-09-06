package com.java.spring.study.config;

// import javax.persistence.EntityManagerFactory;

import com.java.spring.study.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.java.spring.study")
@EnableTransactionManagement
public class BeanConfig {
    // @Bean
    // public JpaTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {
    //     return new JpaTransactionManager(entityManagerFactory);
    // }

    @Bean(name = "service")
    public UserService userService () {
        return new UserService();
    }
}
