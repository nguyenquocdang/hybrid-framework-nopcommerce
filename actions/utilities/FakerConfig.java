package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerConfig {
	Faker faker = new Faker(new Locale("en_US"));
 
	public static FakerConfig getFaker() {
		return new FakerConfig();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getCity() {
		return faker.address().city();
	}
	
	public String getStreet() {
		return faker.address().streetAddress();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
		
	public String getPassword() {
		return faker.internet().password();
	}
	
	
}
