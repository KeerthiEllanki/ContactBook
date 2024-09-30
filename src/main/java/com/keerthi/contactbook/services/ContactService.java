package com.keerthi.contactbook.services;

import java.util.List;

import com.keerthi.contactbook.entities.Contact;

public interface ContactService {
	
	Contact saveContact(Contact contact);
	Contact updateContact(Contact contact);
	void deleteContact(Contact contact);
	Contact getContactById(int id);
	List<Contact> getAllContacts();

}
