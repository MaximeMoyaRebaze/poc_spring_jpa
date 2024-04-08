package com.maxime.corePackage.domains.users.dtos.outputs.student;

import com.maxime.corePackage.domains.users.entities.student.StudentEntity;

import java.util.UUID;

public class StudentOutputDTO {

    // ------------
    // ATTRIBUTES :
    // ------------
    private UUID uuid;
    private String name;

    // -------------
    // CONSTRUCTOR :
    // -------------
    public StudentOutputDTO() {
    }

    // ---------
    // BUILDER :
    // ---------
    public StudentOutputDTO withStudentEntity(StudentEntity studentEntity) {
        this.uuid = studentEntity.getUuid();
        this.name = studentEntity.getName();
        return this;
    }

    // -------------------
    // GETTERS / SETTERS :
    // -------------------
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
