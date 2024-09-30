package com.keerthi.contactbook.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keerthi.contactbook.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
