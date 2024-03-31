package mmk.crud.polymorphic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class ControllerCar {
	
	private ServiceCar carService;
	
	public ControllerCar(ServiceCar carService) {
		this.carService = carService;
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Hello Car!");
	}
	@GetMapping
	public ResponseEntity<List<EntityCar>> getCars() {
		return ResponseEntity.ok(carService.getCars());
	}
	@GetMapping("/{id}")
	public ResponseEntity<EntityCar> getCar(@PathVariable int id) {
		return ResponseEntity.ok(carService.getCarById(id));
	}
	
	@PostMapping
	public ResponseEntity<EntityCar> save(@RequestBody EntityCar car) {
		return ResponseEntity.ok(carService.save(car));
	}
	@PutMapping
	public ResponseEntity<EntityCar> update(@RequestBody EntityCar car) {
		return ResponseEntity.ok(carService.update(car));
	}

}
