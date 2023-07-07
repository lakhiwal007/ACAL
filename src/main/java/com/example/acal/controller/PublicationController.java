package com.example.acal.controller;

import com.example.acal.model.Students;
import com.example.acal.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.acal.model.Publication;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acal/publications")
public class PublicationController {

    @Autowired
    PublicationService publicationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Publication> findAllPublications(){
        return publicationService.findAllPublications();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Publication> findById(@PathVariable Integer id){
        return publicationService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Publication publication){
        publicationService.save(publication);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Publication publication, @PathVariable Integer id){
        publicationService.update(publication,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        publicationService.delete(id);
    }
}
