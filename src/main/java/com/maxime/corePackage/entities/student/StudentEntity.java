package com.maxime.corePackage.entities.student;

import com.maxime.corePackage.dtos.inputs.student.StudentCreationInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class StudentEntity {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    private String name;

    // -------------
    // CONSTRUCTOR :
    // -------------
    public StudentEntity() {
    }

    // ---------
    // BUILDER :
    // ---------

    public StudentEntity withStudentCreationInputDTO(StudentCreationInputDTO studentCreationInputDTO) {
        this.name = studentCreationInputDTO.getName();
        return this;
    }

    public StudentEntity withName(String name) {
        this.name = name;
        return this;
    }

    // -----------------
    // GETTER / SETTER :
    // -----------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // -----------
    // TO STRING :
    // -----------
    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + '}';
    }

}
