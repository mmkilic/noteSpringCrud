package mmk.crud.fetch;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ControllerUser {
	
	private ServiceUser userService;
	
	public ControllerUser(ServiceUser userService) {
		this.userService = userService;
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Hello User!");
	}
	@GetMapping
	public ResponseEntity<List<EntityUser>> getUsers() {
		return ResponseEntity.ok(userService.getUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<EntityUser> getUser(@PathVariable int id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
	@GetMapping("/subordinates")
	public ResponseEntity<List<EntityUser>> getSubordinates(@RequestParam(required = true) int managerId) {
		return ResponseEntity.ok(userService.getSubordinates(managerId));
	}
	
	@PostMapping
	public ResponseEntity<EntityUser> save(@RequestBody EntityUser user) {
		return ResponseEntity.ok(userService.save(user));
	}
	@PutMapping
	public ResponseEntity<EntityUser> update(@RequestBody EntityUser user) {
		return ResponseEntity.ok(userService.merge(user));
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "ok";
	}

}
