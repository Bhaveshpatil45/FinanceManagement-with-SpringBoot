package com.personal_Finance_Management_System.Personal_finance_management_System.controller;

import com.personal_Finance_Management_System.Personal_finance_management_System.dto.UserDto;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import com.personal_Finance_Management_System.Personal_finance_management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        User registeredUser = userService.registerUser(userDto);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}

