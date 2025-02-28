package com.jaberrantisi.contactmanager.controller;


import com.jaberrantisi.contactmanager.model.Contact;
import com.jaberrantisi.contactmanager.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Contact>> getAllContacts(@PathVariable UUID userId) {
        List<Contact> contacts = contactService.getAllContacts(userId);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{userId}/{firstName}")
    public ResponseEntity<List<Contact>> getContactByFirstName(@PathVariable UUID userId, @PathVariable String firstName) {
        List<Contact> contacts = contactService.getContactsByFirstName(firstName, userId);
        return ResponseEntity.ok(contacts);
    }



}
