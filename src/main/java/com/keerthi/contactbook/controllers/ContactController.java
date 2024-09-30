package com.keerthi.contactbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keerthi.contactbook.entities.Contact;
import com.keerthi.contactbook.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService service;
	
	@GetMapping("/createContact")
	String createContact() {
		return "createContact";
	}
	
	@PostMapping("/saveContact")
	String saveContact(@ModelAttribute Contact contact, ModelMap modelMap) {
		Contact savedContact = service.saveContact(contact);
		String msg = "Contact with Id:" + savedContact.getId() + " saved successfully";
		modelMap.addAttribute("msg", msg);
		return "createContact";
	}

	@GetMapping("/displayContacts")
	String displayContacts(ModelMap modelMap) {
		List<Contact> contacts = service.getAllContacts();
		modelMap.addAttribute("contacts", contacts);
		return "displayContacts";
	}
	
	@GetMapping("/deleteContact")
	String deleteContact(@RequestParam int id, ModelMap modelMap) {
		Contact contact = new Contact();
		contact.setId(id);
		service.deleteContact(contact);
		List<Contact> contacts = service.getAllContacts();
		modelMap.addAttribute("contacts", contacts);
		String msg = "Contact with Id:" + id + " deleted successfully";
		modelMap.addAttribute("msg", msg);
		return "displayContacts";
	}
	
	@GetMapping("/showUpdateContact")
	String showUpdateContact(@RequestParam int id, ModelMap modelMap) {
		Contact contact = service.getContactById(id);
		modelMap.addAttribute("contact", contact);
		return "updateContact";
	}

	@PostMapping("/updateContact")
	String updateContact(@ModelAttribute Contact contact, ModelMap modelMap) {
		Contact updatedContact = service.updateContact(contact);
		List<Contact> contacts = service.getAllContacts();
		modelMap.addAttribute("contacts", contacts);
		String msg = "Contact with Id:" + updatedContact.getId() + " updated successfully";
		modelMap.addAttribute("msg", msg);
		return "displayContacts";
	}

}
