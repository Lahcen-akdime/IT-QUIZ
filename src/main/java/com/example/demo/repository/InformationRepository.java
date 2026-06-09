package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
    
    @Query("SELECT text FROM Information")
    List<String> getAllInformationText() ;
        
}

