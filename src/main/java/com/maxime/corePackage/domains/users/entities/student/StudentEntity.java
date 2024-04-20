package com.maxime.corePackage.domains.users.entities.student;

import com.maxime.corePackage.domains.users.dtos.inputs.student.StudentCreationInputDTO;
import com.maxime.corePackage.domains.users.usecases.student.CreateStudentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class StudentEntity {
    @Id
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
	private UUID id;

	private String name;

	// -------------
	// CONSTRUCTOR :
	// -------------
	public StudentEntity() {
	}

	// ---------
	// BUILDER :
	// ---------

	public StudentEntity withStudentCreationInputDTO(StudentCreationInputDTO studentCreationInputDTO) {
		this.name = studentCreationInputDTO.getName();
		return this;
	}

	public StudentEntity withCreateStudentRequest(CreateStudentRequest createStudentRequest) {
		this.name = createStudentRequest.getName();
		return this;
	}

	public StudentEntity withName(String name) {
		this.name = name;
		return this;
	}

	// -------------------
	// GETTERS / SETTERS :
	// -------------------
	public UUID getUuid() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

    public void setName(String name) {
        this.name = name;
    }

    // -----------
    // TO STRING :
    // -----------
    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + '}';
    }

}
