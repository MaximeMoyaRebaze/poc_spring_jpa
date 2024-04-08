package com.maxime.corePackage.domains.users.repositories.student;

import com.maxime.corePackage.domains.users.entities.student.StudentEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class InMemoryStudentRepository implements StudentRepository {

    public HashMap<UUID, StudentEntity> studentEntityHashMap = new HashMap<>();

    @Override
    public List<StudentEntity> findAll() {
        return studentEntityHashMap.values().stream().toList();
    }

    @Override
    public Optional<StudentEntity> findByName(String name) {
        return this.studentEntityHashMap.values().stream().filter(student -> Objects.equals(name, student.getName())).findFirst();
    }

    @Override
    public Boolean existsStudentByName(String name) {
        return this.studentEntityHashMap.values().stream().anyMatch(student -> Objects.equals(name, student.getName()));
    }

    @Override
    public Boolean isStudentExist(String name) {
        return this.studentEntityHashMap.values().stream().anyMatch(student -> Objects.equals(name, student.getName()));
    }

    @Override
    public UUID getIdOfStudent(String name) {
        Optional<StudentEntity> optionalStudentEntity =
                this.studentEntityHashMap.values()
                        .stream()
                        .filter(student -> Objects.equals(name, student.getName()))
                        .findFirst();
        return optionalStudentEntity.map(StudentEntity::getUuid).orElse(null);
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        UUID uuid = UUID.randomUUID();
        studentEntity.setId(uuid);
        this.studentEntityHashMap.put(uuid, studentEntity);
        return studentEntity;
    }

    @Override
    public void saveAllAndFlush(List<StudentEntity> studentEntities) {
        for (StudentEntity studentEntity : studentEntities) {
            this.studentEntityHashMap.put(studentEntity.getUuid(), studentEntity);
        }
    }

}
