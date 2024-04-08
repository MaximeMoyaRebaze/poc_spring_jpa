package com.maxime.corePackage.domains.users.repositories.student;

import com.maxime.corePackage.domains.users.entities.student.StudentEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// TODO => understand why need extends JpaRepository<StudentEntity, Long>
// @Repository
// public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
public interface StudentRepository {

    // ------------------
    // Automatic queries :
    // ------------------

    List<StudentEntity> findAll();

    Optional<StudentEntity> findByName(String name);

    Boolean existsStudentByName(String name);

    // ------------------
    // Specific queries :
    // ------------------

    @Query("SELECT CASE WHEN count(s) > 0 THEN true ELSE false END FROM StudentEntity s WHERE s.name = ?1")
    Boolean isStudentExist(String name);

    @Query("SELECT s.id FROM StudentEntity s WHERE s.name = ?1")
    UUID getIdOfStudent(String name);

    StudentEntity save(StudentEntity studentEntity);

    void saveAllAndFlush(List<StudentEntity> studentEntities);

}
