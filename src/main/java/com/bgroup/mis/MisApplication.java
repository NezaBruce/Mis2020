package com.bgroup.mis;

import org.springframework.boot.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgroup.mis.model.Department;
import com.bgroup.mis.model.Student;
import com.bgroup.mis.repository.DepartmentRepository;
import com.bgroup.mis.repository.StudentRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@SpringBootApplication
@RestController
public class MisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLinerRunner(StudentRepository studentRepository) {
		return args->{
//			Department dp = new Department("Software EngineeringA");
//			departmentRepository.save(dp);						
//			
//			System.out.println("The number of students are: ");
//											
//			Department dpt = departmentRepository.findById(1).get();
//			Student student= new Student("jane","Mutoni","amustonai@gmail.com",LocalDate.now());
			
			Student student= new Student(1L,"jane","Mutoni","amutonai@gmail.com",LocalDate.now());
//			studentRepository.save(student);
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d/MM/yyyy");
			String date="20/02/2003";
			LocalDate localDate=LocalDate.parse(date,formatter);
			Student student2= new Student("Peter","Kagabo","apeteraa@gmail.com",localDate);
			String date3="20/12/2005";
			LocalDate localDate3=LocalDate.parse(date3,formatter);
			Student student3= new Student("James","aKagabo","ajmva@gmail.com",localDate3);
//			List<Student> students=new ArrayList<Student>();
//			students.add(student2);
//			students.add(student);
//			studentRepository.saveAll(students);
//			studentRepository.saveAll(List.of(student,student2,student3));
			System.out.println("The number of students are: "+studentRepository.count());
			studentRepository.findAll().forEach(System.out::println);
			System.out.println("Alternative");
			List<Student> students=studentRepository.findAll();
			for(Student std:students) {
				System.out.println(std);
			}
			System.out.println("Find a student by ID");
			studentRepository.findById(1L).ifPresent(System.out::println);
//			studentRepository.deleteById(2L);
			System.out.println("After deleting 2: ");
			studentRepository.findAll().forEach(System.out::println);
		};
	}
	@GetMapping("mis/api/hello")
	public String hello() {
		return "Hello world";
	}
}