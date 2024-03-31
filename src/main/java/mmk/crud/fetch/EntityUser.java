package mmk.crud.fetch;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@TableGenerator(name="tab", initialValue=10_000, allocationSize=1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator="tab")
	private int id;
	@Column(unique=true, nullable = false)
	private String email;
	private String name;
	private String surname;
	private String password;
	@Enumerated(EnumType.STRING)
	private EnumDepartments department = EnumDepartments.NONE;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateCreated;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateDeactivated;

	@JoinColumn(name="manager_id")
	@ManyToOne
	private EntityUser manager;
	@JsonIgnore
    @OneToMany(mappedBy="manager")
	private Set<EntityUser> subordinates = new HashSet<EntityUser>();
	
	public String getFullName() {
		return name + " " + surname;
	}
}
