package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ;
    private User userEntity ;

    public List<User> getAllUsers(){
        return userRepository.findAll() ;
    }
    public User getUserByName(String name){
        return userRepository.findByName(name) ;
    }
    public User BuildUser(String name , String email , String password){
        return userEntity.builder().name(name).email(email).password(password).build() ;
    }
    public void saveUser(User user){
         userRepository.save(user) ;
    }
    public UserRepository getUserRepository(){
        return userRepository ;
    }

}
