package mmk.crud;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import mmk.crud.fetch.EntityInstructor;
import mmk.crud.fetch.EntityLesson;
import mmk.crud.fetch.EntityStudent;
import mmk.crud.fetch.ServiceSchool;

@SpringBootTest
class SpringCrudApplicationTestsSchool {

	private ObjectMapper mapper;
	@Autowired
	private ServiceSchool schoolService;
	
	@Test
	void contextLoads() {
		System.out.println("Test Start..");
		
		mapper = JsonMapper.builder()
				.addModule(new ParameterNamesModule())
				.addModule(new Jdk8Module())
				.addModule(new JavaTimeModule())
				.build();
		
		initStudent("/json/student.json");
		initInstructor("/json/instructor.json");
		initLesson("/json/lesson.json");
	}
	
	void initStudent(String file) {
		TypeReference<List<EntityStudent>> typeReference = new TypeReference<List<EntityStudent>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(file);
		try {
			List<EntityStudent> students = mapper.readValue(inputStream, typeReference);
			for (EntityStudent student : students) {
				schoolService.save(student);
				System.out.println("Student have been saved.");
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	void initInstructor(String file) {
		TypeReference<List<EntityInstructor>> typeReference = new TypeReference<List<EntityInstructor>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(file);
		try {
			List<EntityInstructor> instructors = mapper.readValue(inputStream, typeReference);
			for (EntityInstructor instructor : instructors) {
				schoolService.save(instructor);
				System.out.println("Instructor have been saved.");
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	void initLesson(String file) {
		TypeReference<List<EntityLesson>> typeReference = new TypeReference<List<EntityLesson>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(file);
		try {
			List<EntityLesson> lessons = mapper.readValue(inputStream, typeReference);
			for (EntityLesson lesson : lessons) {
				/*
				lesson.getInstructor().getLessons().add(lesson);
				
				lesson.getStudents().stream().forEach(s -> {
					s.getLessons().add(lesson);
				});
				*/
				/*
				var instructor = lesson.getInstructor();
				instructor.getLessons().add(lesson);
				schoolService.save(instructor);
				
				var students = lesson.getStudents();
				students.stream().forEach(s -> {
					s.getLessons().add(lesson);
					schoolService.save(s);
				});
				*/
				lesson.setInstructor(schoolService.getInstructor(lesson.getInstructor().getId()));
				lesson.getInstructor().getLessons().add(lesson);
				lesson.getStudents().stream().forEach(s -> {
					s = schoolService.getStudent(s.getId());
				});
				schoolService.save(lesson);
				
				
				
				System.out.println("Lesson have been saved.");
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
