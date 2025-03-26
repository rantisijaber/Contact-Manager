package com.jaberrantisi.contactmanager.controller;


import com.jaberrantisi.contactmanager.model.Contact;
import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.service.ContactService;
import com.jaberrantisi.contactmanager.service.S3Service;
import com.jaberrantisi.contactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;
    private final S3Service s3Service;
    public ContactController(ContactService contactService, UserService userService, S3Service s3Service) {
        this.contactService = contactService;
        this.userService = userService;
        this.s3Service = s3Service;
    }

    @Value("${aws.bucket.name}")
    private String bucketName;




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
                                                 @RequestPart Contact updatedContact,
                                                 @RequestPart(required = false) MultipartFile image) {

        if (image != null && !image.isEmpty()) {
            String key = "contacts/" + contactId + "/" + image.getOriginalFilename();
            try {
                s3Service.putObject(bucketName, key, image.getBytes());
                updatedContact = updatedContact.toBuilder().profilePictureUrl(image.getOriginalFilename()).build();
                Contact contact = contactService.updateContact(contactId, updatedContact);
            } catch(IOException e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        Contact contact = contactService.updateContact(contactId, updatedContact);


        return ResponseEntity.ok(contact);


    }

    @PostMapping("/{userId}")
    public ResponseEntity<Contact> createContact(@PathVariable UUID userId,
                                                 @RequestPart Contact createdContact, @RequestPart(required = false) MultipartFile image) {

        try {
            if (image != null && !image.isEmpty()) {
                String key = "contacts/" + UUID.randomUUID() + "/" + image.getOriginalFilename();
                s3Service.putObject(bucketName, key, image.getBytes());
                createdContact = createdContact.toBuilder().profilePictureUrl(image.getOriginalFilename()).build();
            }

            User user = userService.findUserById(userId);
            Contact contact = contactService.saveContact(createdContact, user);

            return ResponseEntity.ok(contact);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }



    @DeleteMapping("/{contactId}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable UUID contactId) {
        Boolean contactDeleted = contactService.deleteContact(contactId);
        return ResponseEntity.ok(contactDeleted);
    }
}
