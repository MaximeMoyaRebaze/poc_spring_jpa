package com.maxime.corePackage;

import com.maxime.corePackage.domains.users.repositories.student.InMemoryStudentRepository;
import com.maxime.corePackage.domains.users.repositories.student.StudentRepository;
import com.maxime.corePackage.domains.users.services.student.StudentService;
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
            this.studentRepository = new InMemoryStudentRepository();
        }
        return studentRepository;
    }

    public StudentService getStudentService() {
        if (Objects.isNull(studentService)) {
            this.studentService = new StudentService(getStudentRepository());
        }
        return studentService;
    }

}
