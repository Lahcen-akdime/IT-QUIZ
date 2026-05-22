package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.ChangePasswordRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")


public class UserRestController {

    @Autowired
    private UserService userService ;
    
    // @GetMapping("user")
    // public String get(@RequestParam String name , @RequestParam String email , @RequestParam String password){
    //     User newUser = userService.BuildUser(name, email, password) ;
    //                                     try {
    //                                         userService.saveUser(newUser) ;
    //                                     } catch (Exception e) {
    //                                         return e.toString() ;
    //                                     }
        
    //     return userService.getUserByName(name).toString() ;
        
    // }
    @PostMapping("/me/password")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void changePassword(@RequestBody @Valid final ChangePasswordRequest request , final Authentication principal)throws Exception {
       this.userService.changePassword(this.getUserId(principal),request);
    }

    private Long getUserId(final Authentication principal){
        return ((User) principal.getPrincipal()).getId() ;
    }
    
}
