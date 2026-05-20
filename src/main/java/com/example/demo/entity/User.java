package com.example.demo.entity;

import java.util.Collection;
import java.util.List;

import com.example.demo.interfaces.UserDetails;

import jakarta.persistence.CascadeType;

// import javax.management.relation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id ;
    @NonNull
    private String name ;
    
    @Column(nullable = false , unique = true )
    private String email ;
    
    @NonNull
    private String password ;
    
    @OneToOne(
        cascade = CascadeType.ALL
    )
    private Role role ;
    
    public String getPassword(){
        return this.password ;
    }

    public String getUsername(){
        return this.name ;
    }

    public Role getRole (){
        return this.role ;
    }
}
