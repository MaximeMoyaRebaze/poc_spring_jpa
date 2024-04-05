package com.maxime.corePackage.services.student;

import com.maxime.corePackage.dtos.inputs.student.StudentCreationInputDTO;
import com.maxime.corePackage.entities.student.StudentEntity;
import com.maxime.corePackage.exceptions.AlreadyExistException;
import com.maxime.corePackage.repositories.student.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity addStudent(StudentCreationInputDTO studentCreationInputDTO, URI type) {
        if (studentRepository.findByName(studentCreationInputDTO.getName()).isPresent()) {
            throw new AlreadyExistException("student with the name '" + studentCreationInputDTO.getName() + "' already exist", type);
        }
        return studentRepository.save(new StudentEntity().withStudentCreationInputDTO(studentCreationInputDTO));
    }

    public Boolean isStudentExist(String name) {
        return studentRepository.isStudentExist(name);
    }


}
