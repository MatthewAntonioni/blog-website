package com.example.demo.Login;

import com.example.demo.Login.User;

import org.springframework.data.jpa.repository.JpaRepository;

//serarches database by username and returns user object if found

    public interface UserRepo extends JpaRepository<User, Integer> {
        User findByUsername(String username);
    }
    

