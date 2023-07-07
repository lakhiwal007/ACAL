package com.example.acal.controller;
import  com.example.acal.dao.studentsRepository;
import com.example.acal.service.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.acal.model.Students;

 import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/acal/students")
@CrossOrigin
public class studentsController {
    @Autowired
    StudentService studentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Students> findAllStudents(){
        return studentService.findAllStudents();
    }

     @ResponseStatus(HttpStatus.OK)
     @GetMapping("/{id}")
     public Optional<Students> findById(@PathVariable Integer id){
         return studentService.findById(id);
     }

     @ResponseStatus(HttpStatus.CREATED)
     @PostMapping("")
     public void create(@Valid @RequestBody Students student){
         studentService.save(student);
     }

     @ResponseStatus(HttpStatus.NO_CONTENT)
     @PutMapping("/{id}")
     public void update(@RequestBody Students student, @PathVariable Integer id){
         studentService.update(student,id);
     }

     @ResponseStatus(HttpStatus.NO_CONTENT)
     @DeleteMapping("/{id}")
     public void delete(@PathVariable Integer id){
         studentService.delete(id);
     }
    
}
