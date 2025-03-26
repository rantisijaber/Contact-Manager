package com.jaberrantisi.contactmanager.controller;


import com.jaberrantisi.contactmanager.model.Contact;
import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.service.ContactService;
import com.jaberrantisi.contactmanager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;
    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }




    @GetMapping("/{userId}")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable UUID userId,
                                                     @RequestParam(required = false) String firstName,
                                                     @RequestParam(required = false) String lastName,
                                                     @RequestParam(required = false) String email,
                                                     @RequestParam(required = false) String phoneNumber) {

        User user = userService.findUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<Contact> contacts = contactService.getAllContacts(user, firstName, lastName, email, phoneNumber);
        return ResponseEntity.ok(contacts);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable UUID contactId,
                                                 @RequestBody Contact updatedContact) {

        Contact contact = contactService.updateContact(contactId, updatedContact);
        return ResponseEntity.ok(contact);


    }

    @PostMapping("/{userId}")
    public ResponseEntity<Contact> createContact(@PathVariable UUID userId,
                                                 @RequestBody Contact createdContact) {
        User user = userService.findUserById(userId);
        Contact contact = contactService.saveContact(createdContact, user);
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable UUID contactId) {
        Boolean contactDeleted = contactService.deleteContact(contactId);
        return ResponseEntity.ok(contactDeleted);
    }
}
