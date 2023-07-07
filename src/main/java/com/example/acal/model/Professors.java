package com.example.acal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Professors {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="proff_Id")
    private Integer proffId;

    @Column(name="name")
    private String Name ;


    @Column(name="email")
    private String Email;

    @Enumerated(EnumType.STRING)
    @Column(name="department_name")
    private Department departmentName;

    @Column(name="designation")
    private String designation;
}
