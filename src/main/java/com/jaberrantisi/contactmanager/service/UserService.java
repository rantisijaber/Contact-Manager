package com.jaberrantisi.contactmanager.service;

import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManager manager;
    private final JWTService jwtService;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder, AuthenticationManager manager, JWTService jwtService) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.manager = manager;
        this.jwtService = jwtService;
    }

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword())); // Ensure the password is encoded
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public String verify(User user) {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        return "Failure";
    }

    public User findUserById(UUID userId) {
        return userRepo.findById(userId).orElse(null);
    }




}

