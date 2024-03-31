package mmk.crud;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import mmk.crud.fetch.EntityUser;
import mmk.crud.fetch.ServiceUser;
import mmk.crud.polymorphic.EntityCar;
import mmk.crud.polymorphic.ServiceCar;

@SpringBootTest
class SpringCrudApplicationTests {

	private ObjectMapper mapper;
	@Autowired
	private ServiceUser userService;
	@Autowired
	private ServiceCar carService;
	
	@Test
	void contextLoads() {
		System.out.println("Test Start..");
		
		mapper = JsonMapper.builder()
				.addModule(new ParameterNamesModule())
				.addModule(new Jdk8Module())
				.addModule(new JavaTimeModule())
				.build();
		
		initUser("/json/user.json");
		initCar("/json/car.json");
	}
	
	void initUser(String file) {
		TypeReference<List<EntityUser>> typeReference = new TypeReference<List<EntityUser>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(file);
		try {
			List<EntityUser> users = mapper.readValue(inputStream, typeReference);
			for (EntityUser user : users) {
				if(user.getManager() != null)
					user.setManager(userService.getUserByMail(user.getManager().getEmail()));
				userService.save(user);
				System.out.println("User have been saved.");
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	void initCar(String file) {
		TypeReference<List<EntityCar>> typeReference = new TypeReference<List<EntityCar>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream(file);
		try {
			List<EntityCar> cars = mapper.readValue(inputStream, typeReference);
			for (EntityCar car : cars) {
				carService.save(car);
				System.out.println("Car have been saved.");
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
