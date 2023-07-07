package com.example.acal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "publicationId")
    private Integer Id;

    @Column(name="Title")
    private String Title;

    @ManyToMany
    @Column(name="Author")
    private List<Students> Author;

    @ManyToMany
    @Column(name="CoAuthor")
    private List<Professors> CoAuthor;

    @Column(name="Abstract")
    private String Abstract;

    @Column(name="PublishedDate")
    private Date PublishedDate;

    @Column(name="Publisher")
    private String Publisher;

}
