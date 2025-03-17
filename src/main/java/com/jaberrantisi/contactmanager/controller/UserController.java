package com.jaberrantisi.contactmanager.controller;
import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/user-list")
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(userService.verify(user));
    }
}
