package com.snhu.cs320.mobileappilcation.contact;

import java.util.ArrayList;

/* *
 * 		File: ContactService.java
 * 		Class: ContactService 
 * 		@author: your name
 * 		Description: Contact service for a mobile application
 * 		
 */
public class ContactService {

	private ArrayList<Contact> contacts;
	
	/** 
	 * Constructor: 
	 * Creates a contact service instance
	 */
	public ContactService() {
		
		contacts = new ArrayList<>();
		
	}
	
	/** 
	 * Adds a contact to the in memory data structure. 
	 * @param id A string representing the unique ID of the contact 
	 * @param firstName A string representing the first name of contact
	 * @param lastName A string representing the last name of contact
	 * @param phone A string representing the phone number of contact
	 * @param address A string representing the address of contact
	 * @throws Exception
	 */
	public void addContact(String id, String firstName, String lastName, String phone, String address) throws Exception {
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		if(contacts.isEmpty()) {
			contacts.add(newContact);
		}
		else {
			for(int i = 0; i < contacts.size(); i++) {
				if(contacts.get(i).getId().equals(newContact.getId())) {
					throw new Exception("Unique ID constraint violated. A contact with that ID already exists.");
				}
			}
			contacts.add(newContact);
		}
	}
	
	/**
	 * Deletes a contact based on the unique ID number of the contact
	 * @param id A string representing the ID of the contact to be deleted
	 * @throws Exception 
	 */
	public void deleteContact(String id) throws Exception {
		contacts.remove(findContactIndex(id));
	}
	
	/**
	 * Updates a contact based on the unique ID number of the contact
	 * @param id A string representing the ID number of the contact to be updated
	 * @param firstName A string representing first name value to be updated
	 * @param lastName A string representing last name value to be updated
	 * @param phone A string representing phone value to be updated
	 * @param address A string representing address value to be updated
	 * @throws Exception 
	 */
	public void updateContact(String id, String firstName, String lastName, String phone, String address) throws Exception {
		int indexToUpdate = findContactIndex(id);
		contacts.get(indexToUpdate).setFirstName(firstName);
		contacts.get(indexToUpdate).setLastName(lastName);
		contacts.get(indexToUpdate).setPhone(phone);
		contacts.get(indexToUpdate).setAddress(address);
	}
	
	/**
	 * Returns a contact object based on the ID 
	 * @param id A string representing the ID number of the contact to return 
	 * @return A Contact object based on the contact ID number supplied
	 * @throws Exception 
	 */
	public Contact getContact(String id) throws Exception {
		return contacts.get(findContactIndex(id));
	}
	
	/**
	 * Returns the array list of contacts
	 * @return An array list of all contacts
	 */
	public ArrayList<Contact> getContacts() {
		return contacts; 
	}
	
	/**
	 * Internal method for finding the index number of a contact within the contacts array. 
	 * @param id A string representing representing the ID number of the contact to find the index value of 
	 * @return An int representing the index value of the contact within the contacts array 
	 * @throws Exception
	 */
	private int findContactIndex(String id) throws Exception {
		int i = 0; 
		boolean contactFound = false; 
		
		if(contacts.size() == 0) {
			throw new Exception("No contacts exist.");
		}
		
		while(!contactFound) {
			if(!contacts.get(i).getId().equals(id)) {
				i++;
				
				if(i >= contacts.size()) {
					throw new Exception("A contact with that ID does not exist.");
				}
				
			}
			else {
				contactFound = true; 
			}
		}
		
		return i;
	}
	
	
}
