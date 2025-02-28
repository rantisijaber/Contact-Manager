package com.jaberrantisi.contactmanager.repository;

import com.jaberrantisi.contactmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {


}
