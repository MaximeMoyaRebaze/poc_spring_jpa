package com.maxime.corePackage.inMemory.student;

import com.maxime.corePackage.CoreTestAbstractClass;
import com.maxime.corePackage.dtos.inputs.student.StudentCreationInputDTO;
import com.maxime.corePackage.entities.student.StudentEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.URI;
import java.util.List;

public class StudentUseCaseTest extends CoreTestAbstractClass {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class GivenNothing {
        @BeforeAll
        void setUp() {
            System.out.println("TestSetUp");
        }

        @Test
        void addStudentTest() {

            String studentName = "Paul";
            getStudentService().addStudent(new StudentCreationInputDTO(studentName), URI.create("test"));
            List<StudentEntity> studentEntities = getStudentService().getStudents();
            Assertions.assertThat(studentEntities).isNotEmpty();
            Assertions.assertThat(studentEntities.size()).isEqualTo(1);
            Assertions.assertThat(studentEntities.get(0).getName()).isEqualTo(studentName);

        }

        //        @Test
        //        void contextConfigsShouldLoaded() {
        //
        //            // StudentConfig
        //            List<StudentEntity> studentEntities = getStudentService().getStudents();
        //            Assertions.assertThat(studentEntities).isNotEmpty();
        //            Assertions.assertThat(studentEntities.get(0).getName()).isEqualTo(studentConfigName + 0);
        //
        //        }

    }

}
