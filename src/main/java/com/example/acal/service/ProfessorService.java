package com.example.acal.service;

import com.example.acal.dao.ProfessorRepository;
import com.example.acal.model.Professors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepo;

    public List<Professors> findAllProfessors(){
        return professorRepo.findAll();
    }

    public Optional<Professors> findById(Integer Id){
        return professorRepo.findById(Id);
    }

    public void save(Professors ps){
        professorRepo.save(ps);
    }

    public void delete(Integer id){
        professorRepo.deleteById(id);
    }

    public void update(Professors prof, Integer id) {
        if(!(professorRepo.existsById(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!");

        Professors ps = professorRepo.findById(id).get();
        ps.setName(prof.getName());
        ps.setEmail(prof.getEmail());
        ps.setDepartmentName(prof.getDepartmentName());
        ps.setDesignation(prof.getDesignation());

        professorRepo.save(ps);
    }
}
