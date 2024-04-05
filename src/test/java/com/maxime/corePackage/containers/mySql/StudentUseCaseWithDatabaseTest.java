package com.maxime.corePackage.containers.mySql;

import com.maxime.corePackage.inMemory.student.StudentUseCaseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith({WithMySQLExtension.class})
public class StudentUseCaseWithDatabaseTest extends StudentUseCaseTest {

}
