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

    // Créer un nouvel utilisateur
    public User createUser(User user) {
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
