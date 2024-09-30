package com.keerthi.contactbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keerthi.contactbook.entities.Contact;
import com.keerthi.contactbook.repos.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	@Override
	public Contact saveContact(Contact contact) {
		return repo.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		return repo.save(contact);
	}

	@Override
	public void deleteContact(Contact contact) {
		repo.delete(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

}
