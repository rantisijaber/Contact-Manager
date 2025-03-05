package com.jaberrantisi.contactmanager.controller;


import com.jaberrantisi.contactmanager.model.Contact;
import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{user}")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable User user,
                                                     @RequestParam(required = false) String firstName,
                                                     @RequestParam(required = false) String lastName,
                                                     @RequestParam(required = false) String email,
                                                     @RequestParam(required = false) String phoneNumber) {
        List<Contact> contacts = contactService.getAllContacts(user, firstName, lastName, email, phoneNumber);
        return ResponseEntity.ok(contacts);
    }










}
