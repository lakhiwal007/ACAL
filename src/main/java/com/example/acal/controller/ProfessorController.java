package com.example.acal.controller;

import com.example.acal.model.Professors;
import com.example.acal.model.Publication;
import com.example.acal.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acal/professors")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Professors> findAllProfessors(){
        return professorService.findAllProfessors();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Professors> findById(@PathVariable Integer id){
        return professorService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Professors publication){
        professorService.save(publication);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Professors publication, @PathVariable Integer id){
        professorService.update(publication,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        professorService.delete(id);
    }
}
