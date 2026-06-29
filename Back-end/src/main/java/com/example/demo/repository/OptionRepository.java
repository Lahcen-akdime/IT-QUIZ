package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Options;

public interface OptionRepository extends JpaRepository<Options,Integer> {
    
}
