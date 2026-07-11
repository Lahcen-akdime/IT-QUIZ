package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long>{

    public Formation findFormationById(Long id) ;
}
