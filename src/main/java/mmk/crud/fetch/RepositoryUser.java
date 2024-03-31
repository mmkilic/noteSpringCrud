package mmk.crud.fetch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mmk.crud.repostory.CustomizedRepository;

@Repository
public interface RepositoryUser extends JpaRepository<EntityUser, Integer>, CustomizedRepository<EntityUser> {
	
	@Query("SELECT u from EntityUser u where u.email=(:email)")
	Optional<EntityUser> getUserByEmail(@Param("email") String email);
	
	@Query("SELECT u from EntityUser u where u.manager.id=(:managerId)")
	List<EntityUser> getSubordinates(@Param("managerId") int managerId);
	
	@Query("SELECT u from EntityUser u where u.department=(:dapartment)")
	List<EntityUser> getUsersByDepartment(@Param("dapartment") EnumDepartments dapartment);
}
