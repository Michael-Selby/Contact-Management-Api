package com.sterry.contact.repository;

import com.sterry.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {
    Contact findByName(String name);
    Contact findByNumber(String number);
}
