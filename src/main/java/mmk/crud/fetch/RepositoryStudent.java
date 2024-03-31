package mmk.crud.fetch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mmk.crud.repostory.CustomizedRepository;

@Repository
public interface RepositoryStudent extends JpaRepository<EntityStudent, Integer>, CustomizedRepository<EntityStudent> {
	
}
