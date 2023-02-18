package com.snhu.cs320.mobileappilcation.test;

import com.snhu.cs320.mobileappilcation.contact.Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test; 

public class ContactTest {

	@Test
	void testContactIdLongerThan10Characters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		});
		
	}
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(null, "Kyle", "Rocco", "5555555555", "123 Main St");
		});
	}
	
	@Test
	void testContactFirstNameLongerThan10Characters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "KyleKyle", "Rocco", "5555555555", "123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setFirstName("John John John");
		});
		
	}
	
	@Test 
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", null, "Rocco", "5555555555", "123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testContactLastNameLongerThan10Characters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "RoccoRocco", "5555555555", "123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setLastName("Rocco Rocco Rocco Rocco");
		});
	}
	
	@Test 
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", null, "5555555555", "123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setLastName(null);
		});
	}
	
	@Test
	void testContactPhoneNumberNot10Characters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "RoccoRocco", "1", "123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setPhone("123");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setPhone("9999999999");
		});
	}
	
	@Test 
	void testContactPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", null, "123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setPhone(null);
		});
	}
	
	@Test
	void testContactAddressMoreThan30Characters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "RoccoRocco", "5555555555", "123 Main St 123 Main St 123 Main St 123 Main St 123 Main St");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setAddress("123 This Is A Really Long Street Name Street");
		});
	}
	
	@Test 
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Roco", "5555555555", null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
			contact.setAddress(null);
		});
	}
	
	
	

}
