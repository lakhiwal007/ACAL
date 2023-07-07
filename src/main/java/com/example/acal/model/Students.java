package com.example.acal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="student_Id")
    private Integer studentId;

    @Column(name="name")
    private String Name;

    @Column(name="roll_no")
    private Integer RollNo;

    @Enumerated(EnumType.STRING)
    @Column(name="batch_name")
    private Batch batch;

    @Column(name="email")
    private String Email;

    @Enumerated(EnumType.STRING)
    @Column(name="department_name")
    private Department departmentName;

    @Enumerated(EnumType.STRING)
    @Column(name="programme_name")
    private Programme programmeName ;
    
}
