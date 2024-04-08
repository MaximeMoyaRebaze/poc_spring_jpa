package com.maxime.corePackage.domains.users.usecases.student;

import com.maxime.corePackage.domains.users.dtos.inputs.student.StudentCreationInputDTO;
import com.maxime.corePackage.domains.users.dtos.outputs.student.StudentOutputDTO;
import com.maxime.corePackage.domains.users.entities.student.StudentEntity;
import com.maxime.corePackage.domains.users.repositories.student.StudentRepository;
import com.maxime.corePackage.utils.exceptions.AlreadyExistException;

public class AddStudentUseCase {

    private final StudentRepository studentRepository;

    public AddStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentOutputDTO handle(StudentCreationInputDTO studentCreationInputDTO) {
        if (studentRepository.findByName(studentCreationInputDTO.getName()).isPresent()) {
            throw new AlreadyExistException("student with the name '" + studentCreationInputDTO.getName() + "' already exist");
        }
        StudentEntity studentEntity = studentRepository.save(new StudentEntity().withStudentCreationInputDTO(studentCreationInputDTO));
        return new StudentOutputDTO().withStudentEntity(studentEntity);
    }

}
