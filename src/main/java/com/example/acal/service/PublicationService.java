package com.example.acal.service;

import com.example.acal.dao.PublicationRepository;
import com.example.acal.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    @Autowired
    PublicationRepository publicationRepo;

    public List<Publication> findAllPublications(){
        return publicationRepo.findAll();
    }

    public Optional<Publication> findById(Integer Id){
        return publicationRepo.findById(Id);
    }

    public void save(Publication s){
        publicationRepo.save(s);
    }

    public void delete(Integer id){
        publicationRepo.deleteById(id);
    }

    public void update(Publication publication, Integer id) {
        if(!(publicationRepo.existsById(id)))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found!");

        Publication pb = publicationRepo.findById(id).get();
        pb.setTitle(publication.getTitle());
        pb.setAuthor(publication.getAuthor());
        pb.setCoAuthor(publication.getCoAuthor());
        pb.setAbstract(publication.getAbstract());
        pb.setPublisher(publication.getPublisher());
        pb.setPublishedDate(publication.getPublishedDate());
        publicationRepo.save(pb);
    }
}
