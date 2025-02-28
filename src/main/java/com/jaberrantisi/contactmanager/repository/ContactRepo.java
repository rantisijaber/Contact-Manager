package com.jaberrantisi.contactmanager.repository;

import com.jaberrantisi.contactmanager.model.Contact;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepo extends JpaRepository<Contact, UUID> {

    public List<Contact> findAllByUserId(UUID userId);

    public List<Contact> findByFirstNameContainingAndUserId(String firstName, UUID userId);

    public List<Contact> findByLastNameContainingAndUserId(String lastName, UUID userId);

    public List<Contact> findByEmailContainingAndUserId(String email, UUID userId);

    public List<Contact> findByPhoneNumberContainingAndUserId(String phone, UUID userId);

}
