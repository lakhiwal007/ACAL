package com.example.acal.dao;

import com.example.acal.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface studentsRepository extends JpaRepository<Students,Integer> {
}
