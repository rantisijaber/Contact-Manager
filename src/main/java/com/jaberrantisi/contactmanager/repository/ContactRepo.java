package com.jaberrantisi.contactmanager.repository;

import com.jaberrantisi.contactmanager.model.Contact;
import com.jaberrantisi.contactmanager.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepo extends JpaRepository<Contact, UUID> {

    public List<Contact> findAllByUser(User user);

    public List<Contact> findByFirstNameContainingAndUser(String firstName, User user);

    public List<Contact> findByLastNameContainingAndUser(String lastName, User user);

    public List<Contact> findByEmailContainingAndUser(String email, User user);

    public List<Contact> findByPhoneNumberContainingAndUser(String phone, User user);


}
