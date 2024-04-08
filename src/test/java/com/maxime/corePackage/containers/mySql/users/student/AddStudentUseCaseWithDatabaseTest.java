package com.maxime.corePackage.containers.mySql.users.student;

import com.maxime.corePackage.containers.mySql.WithMySQLExtension;
import com.maxime.corePackage.inMemory.users.student.AddStudentUseCaseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith({WithMySQLExtension.class})
public class AddStudentUseCaseWithDatabaseTest extends AddStudentUseCaseTest {

}
