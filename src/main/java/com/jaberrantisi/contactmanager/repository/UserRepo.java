package com.jaberrantisi.contactmanager.repository;

import com.jaberrantisi.contactmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    public User findByUsername(String username);

}
