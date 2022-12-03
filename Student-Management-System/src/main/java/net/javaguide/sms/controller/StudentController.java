package net.javaguide.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguide.sms.entity.Student;
import net.javaguide.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list students and return mode and view
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String  createStudentForm(Model model) {
		
		//create students object to hold students form data
		Student  student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String  updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		//get student from database by id
		Student exitingStudent = studentService.getStudentById(id);
		exitingStudent.setId(id);
		exitingStudent.setFirstName(student.getFirstName());
		exitingStudent.setLastName(student.getLastName());
		exitingStudent.setEmail(student.getEmail());
		
		//save updated student object
		studentService.updateStudent(exitingStudent);
		return "redirect:/students";
		
	}
	//handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	   return"redirect:/students";
		
	}

}
