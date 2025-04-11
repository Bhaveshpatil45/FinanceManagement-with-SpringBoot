package com.personal_Finance_Management_System.Personal_finance_management_System.service;

import com.personal_Finance_Management_System.Personal_finance_management_System.dto.UserDto;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import com.personal_Finance_Management_System.Personal_finance_management_System.repository.UserRepository;
import com.personal_Finance_Management_System.Personal_finance_management_System.exception.UserAlreadyExistsException;
import com.personal_Finance_Management_System.Personal_finance_management_System.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new UserAlreadyExistsException("Username is already taken.");
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException("Email is already registered.");
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = new User(userDto.getUsername(), encodedPassword, userDto.getEmail(), "USER");
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found."));
    }
}

