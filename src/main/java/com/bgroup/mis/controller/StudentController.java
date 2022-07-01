package com.bgroup.mis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bgroup.mis.model.Student;
import com.bgroup.mis.service.StudentServise;

@RestController
@CrossOrigin("http://localhost:8080")
public class StudentController {
@Autowired
	private StudentServise studentService;
@GetMapping("/app/students")
@ResponseStatus(HttpStatus.OK)
public List<Student> listAllStudents(){
	return studentService.listAll();
}
@PostMapping("app/students/post")
//@Response
@ResponseStatus(HttpStatus.OK)
public void addNewStudent(@RequestBody Student student) {
	studentService.addStudent(student);
}
@GetMapping("app/students/{studentid}")
@ResponseStatus(HttpStatus.OK)
public Student findStudentById(@PathVariable("studentid") Long id) {
	Student s= studentService.getStudentById(id);
	if(s!=null) {
		return s;
	}else {
		return null;
	}
}
@PutMapping("app/students/{studentid}")
@ResponseStatus(HttpStatus.OK)
public void updatet(@RequestBody Student student, @PathVariable("studentid") Long id){
	Student s=studentService.getStudentById(id);
	s.setFirstname(student.getFirstname());
	s.setLastname(student.getLastname());
	studentService.addStudent(s);
}
@DeleteMapping("/app/students/{studentid}")
public void deleteStudent(@PathVariable("studentid") Long id) {
	studentService.deleteStudent(studentService.getStudentById(id));
}
@GetMapping("app/students/finder")
public Student getStudentByEmail(@RequestParam("email")	String email) {
	return studentService.studentByEmail(email);
}
//Dynamic Pages
	/* Sample calling
	 * http://localhost:8080/students/pages/?pageSize=10&pageNo=2&sortBy=email
	 * http://localhost:8080/students/pages/?pageSize=50&pageNo=1&sortBy=email
	 * http://localhost:8080/students/pages/?pageSize=10&pageNo=3&sortBy=firstName
	 */
	@GetMapping("students/pages")
	@ResponseStatus(HttpStatus.OK)
  public Page<Student> getPages(
                      @RequestParam(defaultValue = "0") Integer pageNo, 
                      @RequestParam(defaultValue = "10") Integer pageSize,
                      @RequestParam(defaultValue = "id") String sortBy) 
  {
      return studentService.getAllStudent(pageNo, pageSize, sortBy);

  }














//@GetMapping("app/students/finder")
//public Student getStudentBylastname(@RequestParam("lastname")String fname) {
//	return studentService.studentByEmail(fname);
//}
}

