package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String signUpUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()) {
            return "User Exists";
        }
        else{
            userRepository.save(user);
            return "Account creation Successful";
        }
    }

    public String loginUser(User user) {
        Optional<User> u = userRepository.findByEmail(user.getEmail());
        if (u.isEmpty()) {
            return "Invalid email";
        } else if (!u.get().getPassword().equals(user.getPassword())) {
            return "Username/Password incorrect";
        }
        return "Login successful";
    }
    public Optional<User> getUserDetails(Long userId) {
        return userRepository.findById(userId);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}