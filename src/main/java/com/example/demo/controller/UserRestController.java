package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserRestController {

    @Autowired
    private UserService userService ;
    
    @GetMapping("user")
    public String get(@RequestParam String name , @RequestParam String email , @RequestParam String password){
        User newUser = userService.BuildUser(name, email, password) ;
                                        try {
                                            userService.saveUser(newUser) ;
                                        } catch (Exception e) {
                                            return e.toString() ;
                                        }
        
        return userService.getUserByName(name).toString() ;
        
    }
}
