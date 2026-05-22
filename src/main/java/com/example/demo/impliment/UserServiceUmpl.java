package com.example.demo.impliment;

import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ChangePasswordRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class UserServiceUmpl implements UserService{
    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder ;
    private final com.example.demo.mapper.UserMapper UserMapper ;
    public void deleteAccount(Long userId) {
        
    }
    
    public void changePassword(Long userId , final ChangePasswordRequest request)throws Exception  {
        if (!request.getNewPassword().equals(request.getConfirmNewPassword())) {
            throw new Exception("Password not match");
        }
        final User savedUser = this.userRepository.findById(userId)
        .orElseThrow(()->new Exception("User not found"));
        if (!this.passwordEncoder.matches(request.getCurrentPassword(), savedUser.getPassword())) {
            throw new Exception("Password not match");
        }
        final String encoded = this.passwordEncoder.encode(request.getNewPassword());
        savedUser.setPassword(encoded);
        this.userRepository.save(savedUser) ;
    }
    @Override
    public UserDetails loadUserByUsername(final String email)throws UsernameNotFoundException{
        return this.userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(()->new UsernameNotFoundException("Not found email : "+email)) ;
    }
    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities(){
    //     return null ;
    // }
    // public String getPassword(){
    //     return this.password ;
    // }

    // public String getUsername(){
    //     return this.name ;
    // }
}
