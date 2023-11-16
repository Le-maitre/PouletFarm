package com.example.pouletfarm.service;

import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Récupérer un utilisateur par son ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        Optional<User> existingUserByUsername = userRepository.findByUsername(user.getUsernom());
        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());

        if (existingUserByUsername.isPresent() || existingUserByEmail.isPresent()) {
            throw new RuntimeException("Username or email already exists!");
            // You can throw a different exception or handle it based on your application's requirements
            // For example, returning a specific HTTP status code as ResponseEntity in Spring MVC
        }

        return userRepository.save(user);
    }

    // Mettre à jour un utilisateur existant
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsernom(user.getUsernom());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            return userRepository.save(updatedUser);
        } else {
            return null; // Gérer le cas où l'utilisateur n'existe pas
        }
    }

    // Supprimer un utilisateur par son ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
