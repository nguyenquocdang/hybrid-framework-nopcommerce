package javaBasic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Topic_04_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en_US"));
		
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.address().city());
		System.out.println(faker.address().country());
		System.out.println(faker.address().state());
		System.out.println(faker.address().zipCode());
		System.out.println(faker.internet().emailAddress());
		System.out.println(faker.internet().ipV4Address());
		System.out.println(faker.internet().ipV6Address());
		System.out.println(faker.internet().password(6, 12));
		System.out.println(faker.internet().password(6, 12, true));
		
		
		
	}

}
