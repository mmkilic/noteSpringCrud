package mmk.crud.polymorphic;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class EntityCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne
	private EntityWheel wheel;
	@OneToOne
	private EntityEngine engine;
	@OneToMany(mappedBy="car")
	private List<EntityDoor> doors;
	
	
}
