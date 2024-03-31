package mmk.crud.polymorphic;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCar {
	
	private final RepositoryCar carRepo;
	
	public List<EntityCar> getCars() {
		return carRepo.findAll();
	}
	public EntityCar getCarById(int id) {
		return carRepo.findById(id).orElseThrow(() -> new RuntimeException("Car with id " +id+ " not found."));
	}
	public EntityCar getCarByName(String name) {
		return carRepo.findBy(Example.of(new EntityCar(), ExampleMatcher.matchingAny()),
								rp -> rp.stream().filter(r->r.getName().equalsIgnoreCase(name)).findFirst())
						.orElseThrow(() -> new RuntimeException("Car with name " +name+ " not found."));
	}
	public EntityCar getCarByParameters(EntityCar car) {
		return carRepo.findBy(Example.of(car, ExampleMatcher.matchingAny()),
								rp -> rp.stream().filter(r->r.getName().equalsIgnoreCase(car.getName())
															|| r.getId() == car.getId()).findFirst())
						.orElseThrow(() -> new RuntimeException("Car with name " +car.getName()+ " not found."));
	}
	
	public EntityCar save(EntityCar car) {
		return carRepo.save(car);
	}
	public EntityCar update(EntityCar car) {
		return carRepo.merge(car);
	}
	

}
