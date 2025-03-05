package com.jaberrantisi.contactmanager.service;

import com.jaberrantisi.contactmanager.exceptions.ResourceNotFoundException;
import com.jaberrantisi.contactmanager.model.Contact;
import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.repository.ContactRepo;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService {


    private final ContactRepo contactRepo;

    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void saveContact(Contact contact, User user) {
        try {
            contactRepo.save(contact);
        } catch (ConstraintViolationException e) {
            throw new IllegalArgumentException("Contact details are incomplete: " + e.getMessage(), e);
        }
    }

    public void deleteContact(UUID contactId, User user) {
       if (contactRepo.existsById(contactId)) {
           contactRepo.deleteById(contactId);
       } else {
           throw new ResourceNotFoundException();
       }

    }


    public List<Contact> getAllContacts(User user, String firstName, String lastName, String email, String phoneNumber) {
        if (firstName != null) {
            return contactRepo.findByFirstNameContainingAndUser(firstName, user);
        } else if (lastName != null) {
            return contactRepo.findByLastNameContainingAndUser(lastName, user);
        } else if (email != null) {
            return contactRepo.findByEmailContainingAndUser(email, user);
        }
        if (phoneNumber != null) {
            return contactRepo.findByPhoneNumberContainingAndUser(phoneNumber, user);
        } else {
            return contactRepo.findAllByUser(user);
        }

    }




}

