package mmk.crud.fetch;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceUser{
	
	private RepositoryUser userRepo;
	
	public ServiceUser(RepositoryUser userRepo) {
		this.userRepo = userRepo;
	}

	
	public List<EntityUser> getUsers() {
		var users = userRepo.findAll();
		var user = users.get(5);
		System.out.println("Test");
		System.out.println("Manager: " + user.getManager());
		System.out.println("Subordinates: " + user.getSubordinates());
		System.out.println("ManagerSubordinates: " + user.getManager().getSubordinates());
		return users;
	}
	public EntityUser getUserById(int id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " +id+ " not found."));
	}
	public EntityUser getUserByMail(String email) {
		return userRepo.getUserByEmail(email).orElseThrow(() -> new RuntimeException("User with email " +email+ " not found."));
	}
	public List<EntityUser> getUsersByDepartment(EnumDepartments department) {
		return userRepo.getUsersByDepartment(department);
	}
	public List<EntityUser> getSubordinates(int managerId) {
		return userRepo.getSubordinates(managerId);
	}
	
	public EntityUser save(EntityUser user) {
		user.setDateCreated(LocalDateTime.now());
		return userRepo.save(user);
	}
	public EntityUser merge(EntityUser user) {
		return userRepo.merge(user);
	}
	public void delete(int id) {
		userRepo.deleteById(id);
	}
}
