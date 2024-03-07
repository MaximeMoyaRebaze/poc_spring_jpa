package com.maxime.testdatabasemysql.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);

	Boolean existsStudentByName(String name);

	// ------------------
	// Specific queries :
	// ------------------

	@Query("SELECT CASE WHEN count(s) > 0 THEN true ELSE false END FROM Student s WHERE s.name = ?1")
	Boolean isStudentExist(String name);

	@Query("SELECT s.id FROM Student s WHERE s.name = ?1")
	String getIdOfStudent(String name);

}
