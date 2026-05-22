package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByName(String name);
    boolean exexistsByEmailIgnoreCase(String email) ;
    Optional<User> findByEmailIgnoreCase(String email) ;
    @Override
    Optional<User> findById(Long id) ;
}
