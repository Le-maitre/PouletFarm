package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.User;
import com.example.pouletfarm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Récupérer tous les utilisateurs
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
public ResponseEntity<User> loginUser(@RequestBody User loginUser) {
    String email = loginUser.getEmail();
    String password = loginUser.getPassword();

    // Retrieve the user by email from the database
    User user = userService.getUserByEmail(email);

    if (user != null && user.getPassword().equals(password)) {
        // If the user exists and passwords match, return the user details
        return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
        // If credentials are invalid or user not found, return unauthorized status
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}

    // Récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Créer un nouvel utilisateur
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Mettre à jour un utilisateur existant
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un utilisateur par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
