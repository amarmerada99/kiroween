package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repository.UserRepository;

@Service
public class UserService{
    private final UserRepository userRepository;

    //constructor
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //retrieval
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User getUserById(Integer userId){
        return userRepository.findByUserId(userId);
    }
}