package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ;
    private UserEntity userEntity ;

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll() ;
    }
    public UserEntity getUserByName(String name){
        return userRepository.findByName(name) ;
    }
    public UserEntity BuildUser(String name , String email , String password){
        return userEntity.builder().name(name).email(email).password(password).build() ;
    }
    public void saveUser(UserEntity user){
         userRepository.save(user) ;
    }
    public UserRepository getUserRepository(){
        return userRepository ;
    }

}
