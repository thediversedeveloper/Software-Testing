package com.snhu.cs320.mobileappilcation.test;

import com.snhu.cs320.mobileappilcation.contact.Contact;
import com.snhu.cs320.mobileappilcation.contact.ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	@Test
	void testAddContact() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		
		
		Contact contact = contactService.getContact("9999999999);
		assertEquals(contact.getId(), "9999999999");
		assertEquals(contact.getFirstName(), "Kyle");
		assertEquals(contact.getLastName(), "Rocco");
		assertEquals(contact.getPhone(), "5555555555");
		assertEquals(contact.getAddress(), "32 Bryn Mawar Ave");	
		
	}
	
	@Test
	void testUpdateContact() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		
		contactService.updateContact("9999999999", "Boo", "Bear", "1111111111", "456 Main St");
		
		Contact contact = contactService.getContact("9999999999");
		assertEquals(contact.getId(), "9999999999");
		assertEquals(contact.getFirstName(), "Boo");
		assertEquals(contact.getLastName(), "Bear");
		assertEquals(contact.getPhone(), "1111111111");
		assertEquals(contact.getAddress(), "55 Leicester Street");
		
	}
	
	@Test
	void testDuplicateContactId() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		
		Assertions.assertThrows(Exception.class, () -> {
			contactService.addContact("9999999999", "Boo", "Bear", "1234567890", "456 Main St");
		});
	}
	
	@Test
	void testAddMultipleContacts() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		contactService.addContact("9999999999", "Boo", "Bear", "1111111111", "456 Main St");
		
		Contact contact = contactService.getContact("9999999999");
		assertEquals(contact.getId(), "9999999999");
		assertEquals(contact.getFirstName(), "Kyle");
		assertEquals(contact.getLastName(), "Rocco");
		assertEquals(contact.getPhone(), "5555555555");
		assertEquals(contact.getAddress(), "32 Bryn Mawr");	
		
		Contact contact2 = contactService.getContact("9999999999");
		assertEquals(contact2.getId(), "9999999999");
		assertEquals(contact2.getFirstName(), "Boo");
		assertEquals(contact2.getLastName(), "Bear");
		assertEquals(contact2.getPhone(), "1111111111");
		assertEquals(contact2.getAddress(), "55 Leicester Street");	
	}
	
	@Test
	void testDeleteContact() throws Exception {		
		ContactService contactService = new ContactService();
		
		assertEquals(contactService.getContacts().size(),0);
		
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		
		assertEquals(contactService.getContacts().size(),1);
		
		contactService.deleteContact("9999999999");
		
		assertEquals(contactService.getContacts().size(),0);
		
	}
	
	@Test
	void testDeleteContactMoreThanOnce() throws Exception {
		ContactService contactService = new ContactService();
		
		assertEquals(contactService.getContacts().size(),0);
		
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		
		assertEquals(contactService.getContacts().size(),1);
		
		contactService.deleteContact("9999999999");
		
		assertEquals(contactService.getContacts().size(),0);
		
		Assertions.assertThrows(Exception.class, () -> {
			contactService.deleteContact("9999999999");
		});
	}
	
	@Test
	void findContactThatDoesNotExist() throws Exception {
ContactService contactService = new ContactService();
		
		assertEquals(contactService.getContacts().size(),0);
		
		contactService.addContact("9999999999", "Kyle", "Rocco", "5555555555", "123 Main St");
		
		assertEquals(contactService.getContacts().size(),1);
		
		Assertions.assertThrows(Exception.class, () -> {
			contactService.getContact("1123");
		});
		
	}
	
	
	
}
