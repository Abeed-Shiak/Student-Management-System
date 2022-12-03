package net.javaguide.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguide.sms.entity.Student;
import net.javaguide.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {

//		Student student = new Student("abid","shaik","abidshaik@123");
//		studentRepository.save(student);
//		
//		Student student1 = new Student("vidhya","ghowid","vidhyaghowd@852");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student("king","kong","kingkong@025");
//		studentRepository.save(student2);
//		
		
		
		
	}

}
