package com.sterry.contact.controller;

import com.sterry.contact.contactDTO.ContactDTO;
import com.sterry.contact.model.Contact;
import com.sterry.contact.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Contact")
@RequiredArgsConstructor
public class


ContactController {

    public final ContactService contactService;

    @PostMapping("/signup")
    public ResponseEntity<Contact>  createContact( @Valid @RequestBody  ContactDTO contactDTO) {
            Contact newContact=new Contact();
            newContact.setName(contactDTO.getName());
            newContact.setNumber(contactDTO.getNumber());
            Contact createContact=contactService.createContact(newContact);
            return ResponseEntity.status(HttpStatus.CREATED).body(createContact);
    }


    @DeleteMapping("{e}")
    public  ResponseEntity<Contact>  deleteContact(@PathVariable String e){
        contactService.deleteContact(e);
        return ResponseEntity.ok(null);
    }

    @PutMapping("{e}")
    public ResponseEntity<Contact>  updateContact(@PathVariable String e, @RequestBody Contact updatedContact){
        return ResponseEntity.ok(contactService.updateContact(e, updatedContact));
    }

    @GetMapping("{e}")
    public ResponseEntity<Contact> getContact(@PathVariable String e){
        return ResponseEntity.ok(contactService.getContact(e));
    }

}
