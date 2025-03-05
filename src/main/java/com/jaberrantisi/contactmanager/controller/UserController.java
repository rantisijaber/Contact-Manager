package com.jaberrantisi.contactmanager.controller;
import com.jaberrantisi.contactmanager.model.User;
import com.jaberrantisi.contactmanager.service.UserService;
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
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/user-list")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }
}
