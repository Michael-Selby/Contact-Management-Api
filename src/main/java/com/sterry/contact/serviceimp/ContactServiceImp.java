package com.sterry.contact.serviceimp;

import com.sterry.contact.model.Contact;
import com.sterry.contact.repository.ContactRepo;
import com.sterry.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService {
    private final ContactRepo contactRepo;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);

    }

    @Override
    public void deleteContact(String name) {
        Contact contact=contactRepo.findByName(name);
        if(contact!=null){
            contactRepo.delete(contact);
        }
        throw new RuntimeException("name not found");
    }

    @Override
    public Contact updateContact(String name, Contact updatedContact) {
        Contact contactName=contactRepo.findByName(name);
        String number=updatedContact.getNumber();

        if(contactName!=null){
            updatedContact.setName(contactName.getName());
            updatedContact.setNumber(number);
            return updatedContact;
        }
        throw new RuntimeException("name not found");

    }

    @Override
    public Contact getContact(String name) {
        Contact contactName=contactRepo.findByName(name);
        if(contactName!=null){
            return  contactName;
        }
        throw new RuntimeException("name not found");
    }
}
