package com.example.acal.service;

import com.example.acal.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import  com.example.acal.dao.studentsRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    studentsRepository studentRepo;

    public List<Students> findAllStudents(){
        return studentRepo.findAll();
    }

    public Optional<Students> findById(Integer Id){
        return studentRepo.findById(Id);
    }

    public void save(Students s){
        studentRepo.save(s);
    }

    public void delete(Integer id){
        studentRepo.deleteById(id);
    }

    public void update(Students student, Integer id) {
        if(!(studentRepo.existsById(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!");

        Students st = studentRepo.findById(id).get();
        st.setBatch(student.getBatch());
        st.setName(student.getName());
        st.setEmail(student.getEmail());
        st.setRollNo(student.getRollNo());
        st.setDepartmentName(student.getDepartmentName());
        st.setProgrammeName(student.getProgrammeName());
        studentRepo.save(st);
    }
}
