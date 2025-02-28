package com.jaberrantisi.contactmanager.service;

import com.jaberrantisi.contactmanager.exceptions.ResourceNotFoundException;
import com.jaberrantisi.contactmanager.model.Contact;
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

    public void saveContact(Contact contact) {
        try {
            contactRepo.save(contact);
        } catch (ConstraintViolationException e) {
            throw new IllegalArgumentException("Contact details are incomplete: " + e.getMessage(), e);
        }
    }

    public void deleteContact(UUID contactId, UUID userId) {
       if (contactRepo.existsById(contactId)) {
           contactRepo.deleteById(contactId);
       } else {
           throw new ResourceNotFoundException();
       }

    }


    public List<Contact> getAllContacts(UUID userId) {
        return contactRepo.findAllByUserId(userId);

    }


    public List<Contact> getContactsByFirstName(String firstName, UUID userId) {
        return contactRepo.findByFirstNameContainingAndUserId(firstName,userId);
    }

    public List<Contact> getContactsByLastName(String lastName, UUID userId) {
        return contactRepo.findByLastNameContainingAndUserId(lastName, userId);
    }

    public List<Contact> getContactsByEmail(String email, UUID userId) {
        return contactRepo.findByEmailContainingAndUserId(email, userId);
    }

    public List<Contact> getContactsByPhone(String phone, UUID userId) {
        return contactRepo.findByPhoneNumberContainingAndUserId(phone, userId);
    }




}

