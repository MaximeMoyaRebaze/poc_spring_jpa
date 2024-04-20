package com.maxime.corePackage.inMemory.users.student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.maxime.corePackage.CoreTestAbstractClass;
import com.maxime.corePackage.domains.users.entities.student.StudentEntity;
import com.maxime.corePackage.domains.users.response.StudentResponse;
import com.maxime.corePackage.domains.users.usecases.student.CreateStudentRequest;
import com.maxime.corePackage.utils.exceptions.AlreadyExistException;

import java.util.List;

public class CreateStudentTest extends CoreTestAbstractClass {

	@Nested
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	class GivenNoStudents {

		@Nested
		@TestInstance(TestInstance.Lifecycle.PER_CLASS)
		class WhenCreateStudent {
			@Test
			void thenShouldSucceed() {

				String studentName = "Paul";
				StudentResponse studentResponse = new CreateStudentRequest(studentName).execute(pipeline);
				Assertions.assertThat(studentResponse.getName()).isEqualTo(studentName);

				List<StudentEntity> studentEntities = getStudentRepository().findAll();
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
		void createStudent() {
			StudentEntity studentEntity = new StudentEntity().withName(studentName);
			getStudentRepository().save(studentEntity);
		}

		@Nested
		@TestInstance(TestInstance.Lifecycle.PER_CLASS)
		class WhenTriesToAddStudentWithSameNameThanExistingStudent {
			@Test
			void thenShouldFailed() {
				Assertions.assertThatExceptionOfType(AlreadyExistException.class)
						.isThrownBy(() -> new CreateStudentRequest(studentName).execute(pipeline));
			}
		}

	}

}
