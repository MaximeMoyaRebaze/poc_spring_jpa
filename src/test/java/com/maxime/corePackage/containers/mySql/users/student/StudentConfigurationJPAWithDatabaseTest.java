package com.maxime.corePackage.containers.mySql.users.student;

import com.maxime.corePackage.CoreTestAbstractClass;
import com.maxime.corePackage.domains.users.dtos.outputs.student.StudentOutputDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static com.maxime.corePackage.domains.users.configs.student.StudentConfig.studentConfigName;

public class StudentConfigurationJPAWithDatabaseTest extends CoreTestAbstractClass {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class GivenNothing {
        @BeforeAll
        void setUp() {
            System.out.println("TestSetUp");
        }

        @Test
        void contextConfigsShouldLoaded() {

            // StudentConfig
            List<StudentOutputDTO> studentEntities = getStudentService().getAllStudents();
            Assertions.assertThat(studentEntities).isNotEmpty();
            Assertions.assertThat(studentEntities.get(0).getName()).isEqualTo(studentConfigName + 0);

        }

    }

}
