package com.example.acal.dao;

import com.example.acal.model.Professors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professors,Integer> {
}
