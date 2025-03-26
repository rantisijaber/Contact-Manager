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

    public Contact saveContact(Contact contact, User user) {
        try {
            contact.setUser(user);
            contactRepo.save(contact);
            return contact;
        } catch (ConstraintViolationException e) {
            throw new IllegalArgumentException("Contact details are incomplete: " + e.getMessage(), e);
        }
    }

    public boolean deleteContact(UUID contactId) {
       if (contactRepo.existsById(contactId)) {
           contactRepo.deleteById(contactId);
           return true;
       } else {
           throw new ResourceNotFoundException("Contact not found: " + contactId);
       }

    }

    public Optional<Contact> findById(UUID contactId, User user) {
        if (contactRepo.existsById(contactId)) {
            return contactRepo.findById(contactId);
        } else {
            throw new ResourceNotFoundException("Contact not found: " + contactId);
        }
    }


    public List<Contact> getAllContacts(User user, String firstName, String lastName, String email, String phoneNumber) {
        if (firstName != null) {
            return contactRepo.findByFirstNameContainingAndUser(firstName, user);
        } else if (lastName != null) {
            return contactRepo.findByLastNameContainingAndUser(lastName, user); // Make name into one if
        } else if (email != null) {
            return contactRepo.findByEmailContainingAndUser(email, user);
        }
        if (phoneNumber != null) {
            return contactRepo.findByPhoneNumberContainingAndUser(phoneNumber, user);
        } else {
            return contactRepo.findAllByUser(user);
        }

    }

    public Contact updateContact(UUID contactId, Contact updatedContact) {
        // Retrieve the existing contact from the database
        Contact existingContact = contactRepo.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found"));

        if (updatedContact.getFirstName() != null) {
            existingContact.setFirstName(updatedContact.getFirstName());
        }
        if (updatedContact.getLastName() != null) {
            existingContact.setLastName(updatedContact.getLastName());
        }
        if (updatedContact.getEmail() != null) {
            existingContact.setEmail(updatedContact.getEmail());
        }
        if (updatedContact.getPhoneNumber() != null) {
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
        }
        if (updatedContact.getWebsite() != null) {
            existingContact.setWebsite(updatedContact.getWebsite());
        }
        if (updatedContact.getCompanyName() != null) {
            existingContact.setCompanyName(updatedContact.getCompanyName());
        }
        if (updatedContact.getJobTitle() != null) {
            existingContact.setJobTitle(updatedContact.getJobTitle());
        }
        if (updatedContact.getRelationshipType() != null) {
            existingContact.setRelationshipType(updatedContact.getRelationshipType());
        }
        if (updatedContact.getBirthday() != null) {
            existingContact.setBirthday(updatedContact.getBirthday());
        }
        if (updatedContact.getNotes() != null) {
            existingContact.setNotes(updatedContact.getNotes());
        }
        if (updatedContact.getProfilePictureUrl() != null) {
            existingContact.setProfilePictureUrl(updatedContact.getProfilePictureUrl());
        }

        // Save the updated contact to the database
        return contactRepo.save(existingContact);
    }

}






