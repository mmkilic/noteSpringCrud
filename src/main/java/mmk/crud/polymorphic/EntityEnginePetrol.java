package mmk.crud.polymorphic;

import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "petrolEngineId")
@JsonRootName("PETROL")
public class EntityEnginePetrol extends EntityEngine {
	
	private String sparkPlug;

}
