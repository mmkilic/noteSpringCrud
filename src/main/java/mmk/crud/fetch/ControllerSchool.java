package mmk.crud.fetch;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ControllerSchool {
	
	private final ServiceSchool serviceSchool;
	
	@GetMapping("/students")
	public List<EntityStudent> getStudents() {
		return serviceSchool.getStudents();
	}
	@GetMapping("/instructors")
	public List<EntityInstructor> getInstructors() {
		return serviceSchool.getInstructors();
	}
	@GetMapping("/lessons")
	public List<EntityLesson> getLesson() {
		return serviceSchool.getLessons();
	}
	

}
