package com.maxime.corePackage.domains.users.dtos.inputs.student;

public class StudentCreationInputDTO {

    private String name;

    // -------------
    // CONSTRUCTOR :
    // -------------

    public StudentCreationInputDTO(String name) {
        this.name = name;
    }

    // ---------------------
    // GETTERS AND SETTERS :
    // ---------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
