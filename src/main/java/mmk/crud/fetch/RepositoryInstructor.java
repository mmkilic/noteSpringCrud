package mmk.crud.fetch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mmk.crud.repostory.CustomizedRepository;

@Repository
public interface RepositoryInstructor extends JpaRepository<EntityInstructor, Integer>, CustomizedRepository<EntityInstructor> {
	
}
