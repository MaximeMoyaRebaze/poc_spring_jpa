package com.maxime.corePackage.repositories.student;

import com.maxime.corePackage.entities.student.StudentEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InMemoryStudentRepository implements StudentRepository {

    public static HashMap<Long, StudentEntity> studentEntityHashMap = new HashMap<>();

    @Override
    public List<StudentEntity> findAll() {
        return studentEntityHashMap.values().stream().toList();
    }

    @Override
    public Optional<StudentEntity> findByName(String name) {
        return studentEntityHashMap.values().stream().filter(student -> Objects.equals(name, student.getName())).findFirst();
    }

    @Override
    public Boolean existsStudentByName(String name) {
        return studentEntityHashMap.values().stream().anyMatch(student -> Objects.equals(name, student.getName()));
    }

    @Override
    public Boolean isStudentExist(String name) {
        return studentEntityHashMap.values().stream().anyMatch(student -> Objects.equals(name, student.getName()));
    }

    @Override
    public Long getIdOfStudent(String name) {
        Optional<StudentEntity> optionalStudentEntity =
                studentEntityHashMap.values()
                        .stream()
                        .filter(student -> Objects.equals(name, student.getName()))
                        .findFirst();
        return optionalStudentEntity.map(StudentEntity::getId).orElse(null);
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        Long id = Integer.toUnsignedLong(studentEntityHashMap.size());
        studentEntity.setId(id);
        studentEntityHashMap.put(id, studentEntity);
        return studentEntity;
    }

    @Override
    public void saveAllAndFlush(List<StudentEntity> studentEntities) {
        for (StudentEntity studentEntity : studentEntities) {
            studentEntityHashMap.put(studentEntity.getId(), studentEntity);
        }
    }

}
