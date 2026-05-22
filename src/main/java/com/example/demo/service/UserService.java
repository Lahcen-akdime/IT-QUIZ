package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ChangePasswordRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public interface UserService extends UserDetailsService {
    void deleteAccount(Long userId) ;
    void changePassword(Long userId,final ChangePasswordRequest request)throws Exception ;
    // public List<User> getAllUsers(){
    //     return userRepository.findAll() ;
    // }
    // public User getUserByName(String name){
    //     return userRepository.findByName(name) ;
    // }
    // public User BuildUser(String name , String email , String password){
    //     return userEntity.builder().name(name).email(email).password(password).build() ;
    // }
    // public void saveUser(User user){
    //      userRepository.save(user) ;
    // }
    // public UserRepository getUserRepository(){
    //     return userRepository ;
    // }

}
