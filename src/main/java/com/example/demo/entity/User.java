package com.example.demo.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;


import jakarta.persistence.CascadeType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User implements org.springframework.security.core.userdetails.UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NonNull
    @Valid
    private String name ;
    @Column(nullable = false , unique = true )
    @Valid
    private String email ;
    
    @NonNull
    @Valid
    private String password ;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null ;
    }
    public String getPassword(){
        return this.password ;
    }
    @Override
    public String getUsername(){
        return this.email ;
    }
    
    @OneToOne(
        cascade = CascadeType.ALL
    )
    private Role role ;
    

    public Role getRole (){
        return this.role ;
    }
}
