package com.maxime.corePackage.inMemory.users.student;

import com.maxime.corePackage.CoreTestAbstractClass;
import com.maxime.corePackage.domains.users.dtos.inputs.student.StudentCreationInputDTO;
import com.maxime.corePackage.domains.users.dtos.outputs.student.StudentOutputDTO;
import com.maxime.corePackage.utils.exceptions.AlreadyExistException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

public class AddStudentUseCaseTest extends CoreTestAbstractClass {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GivenNoStudents {
        @BeforeAll
        void setUp() {
            System.out.println("TestSetUp");
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class WhenAddStudent {
            @Test
            void thenShouldSucceed() {

                String studentName = "Paul";
                getStudentService().addStudent(new StudentCreationInputDTO(studentName));

                List<StudentOutputDTO> studentEntities = getStudentService().getAllStudents();
                Assertions.assertThat(studentEntities).isNotEmpty();
                Assertions.assertThat(studentEntities.size()).isEqualTo(1);
                Assertions.assertThat(studentEntities.get(0).getName()).isEqualTo(studentName);

            }
        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GivenAStudent {

        private final String studentName = "Paul";

        @BeforeAll
        void setUp() {
            getStudentService().addStudent(new StudentCreationInputDTO(studentName));
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class WhenTriesToAddStudentWithSameNameThanExistingStudent {
            @Test
            void thenShouldFailed() {
                Assertions.assertThatExceptionOfType(AlreadyExistException.class).isThrownBy(
                        () -> getStudentService().addStudent(new StudentCreationInputDTO(studentName))
                );
            }
        }

    }

}
