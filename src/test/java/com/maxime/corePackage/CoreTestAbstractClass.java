package com.maxime.corePackage;

import com.maxime.corePackage.repositories.student.InMemoryStudentRepository;
import com.maxime.corePackage.repositories.student.StudentRepository;
import com.maxime.corePackage.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public abstract class CoreTestAbstractClass {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    // GETTERS :

    public StudentRepository getStudentRepository() {
        if (Objects.isNull(studentRepository)) {
            return new InMemoryStudentRepository();
        } else {
            return studentRepository;
        }
    }

    public StudentService getStudentService() {
        if (Objects.isNull(studentService)) {
            return new StudentService(getStudentRepository());
        } else {
            return studentService;
        }
    }

}
