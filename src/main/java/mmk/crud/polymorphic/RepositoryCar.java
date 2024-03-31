package mmk.crud.polymorphic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mmk.crud.repostory.CustomizedRepository;

@Repository
public interface RepositoryCar extends JpaRepository<EntityCar, Integer>, CustomizedRepository<EntityCar> {
	
	
}
