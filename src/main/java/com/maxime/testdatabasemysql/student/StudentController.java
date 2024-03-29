package com.maxime.testdatabasemysql.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// -----------
	// Endpoints :
	// -----------

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Student> getStudents() {
		return this.studentService.getStudents();
	}
	/*
	GET http://localhost:8081/api/student
	 */

	@GetMapping(value = "/exist/{name}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean studentExistWithPathVariable(@PathVariable String name) {
		return this.studentService.isStudentExist(name);
	}
	/*
	GET http://localhost:8081/api/student/exist/Paul
	 */

	@GetMapping(path = "/exist", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean studentExistWithParameters(@RequestParam String name) {
		return this.studentService.isStudentExist(name);
	}
	/*
	GET http://localhost:8081/api/student/exist?name=Paul
	 */


	@ResponseBody
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Student postStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student, URI.create("POST::" + "api/student"));
	}
	/*
	POST http://localhost:8081/api/student
	Content-Type: application/json

	{
	  "name": "Paul"
	}
	*/

}
