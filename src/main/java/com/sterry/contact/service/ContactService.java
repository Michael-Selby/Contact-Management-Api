package com.sterry.contact.service;

import com.sterry.contact.model.Contact;
import org.springframework.stereotype.Service;



@Service
public interface ContactService {

    Contact createContact(Contact contact);

    void deleteContact(String name);

    Contact updateContact(String name, Contact updatedContact);

    Contact getContact(String name);

}
