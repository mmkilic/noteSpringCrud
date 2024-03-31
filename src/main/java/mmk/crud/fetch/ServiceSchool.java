package mmk.crud.fetch;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceSchool{
	
	private final RepositoryStudent repoStudent;
	private final RepositoryInstructor repoInstructor;
	private final RepositoryLesson repoLesson;

	
	public List<EntityStudent> getStudents() {
		return repoStudent.findAll();
	}
	public List<EntityInstructor> getInstructors() {
		return repoInstructor.findAll();
	}
	public List<EntityLesson> getLessons() {
		return repoLesson.findAll();
	}
	public EntityStudent getStudent(int id) {
		return repoStudent.findById(id).get();
	}
	public EntityInstructor getInstructor(int id) {
		return repoInstructor.findById(id).get();
	}
	public EntityLesson getLesson(int id) {
		return repoLesson.findById(id).get();
	}
	
	public EntityStudent save(EntityStudent student) {
		return repoStudent.save(student);
	}
	public EntityInstructor save(EntityInstructor instructor) {
		return repoInstructor.save(instructor);
	}
	public EntityLesson save(EntityLesson lesson) {
		repoLesson.persist(lesson);
		return null;
	}
}
