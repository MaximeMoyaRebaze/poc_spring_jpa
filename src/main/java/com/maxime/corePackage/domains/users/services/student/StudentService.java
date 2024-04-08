package com.maxime.corePackage.domains.users.services.student;

import com.maxime.corePackage.domains.users.dtos.inputs.student.StudentCreationInputDTO;
import com.maxime.corePackage.domains.users.dtos.outputs.student.StudentOutputDTO;
import com.maxime.corePackage.domains.users.repositories.student.StudentRepository;
import com.maxime.corePackage.domains.users.usecases.student.AddStudentUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    // -------------
    // Dependencies:
    // -------------

    private final StudentRepository studentRepository;

    // ------------
    // Constructor:
    // ------------

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // --------
    // Methods:
    // --------

    public Boolean isStudentExist(String name) {
        return studentRepository.isStudentExist(name);
    }

    public List<StudentOutputDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(
                studentEntity -> new StudentOutputDTO().withStudentEntity(studentEntity)
        ).toList();
    }

    public StudentOutputDTO addStudent(StudentCreationInputDTO studentCreationInputDTO) {
        return new AddStudentUseCase(studentRepository).handle(studentCreationInputDTO);
    }

}
