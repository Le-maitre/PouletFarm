package com.example.pouletfarm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pouletfarm.model.Event;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.service.EventService;
import com.example.pouletfarm.service.UserService;

@RestController
@RequestMapping("/api")
public class EventController {
     private final EventService eventService;
    private final UserService userService;

    @Autowired
    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }
  @PostMapping("/users/{userId}/events")
    public Event createEventForUser(@PathVariable Long userId, @RequestBody Event event) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            event.setUser(user);
            return eventService.createEvent(event);
        } else {
            // Gérer le cas où l'utilisateur n'existe pas pour l'ID spécifié
            return null; // ou retourner une réponse HTTP correspondante
        }
    }

    @GetMapping("/users/{userId}/events")
    public List<Event> getAllEventsForUser(@PathVariable Long userId) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return eventService.getAllEventsForUser(user);
        } else {
            // Gérer le cas où l'utilisateur n'existe pas pour l'ID spécifié
            return null; // ou retourner une réponse HTTP correspondante
        }
    }

    @GetMapping("/users/{userId}/events/{eventId}")
    public Event getEventForUserById(@PathVariable Long userId, @PathVariable Long eventId) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return eventService.getEventForUserById(user, eventId);
        } else {
            // Gérer le cas où l'utilisateur n'existe pas pour l'ID spécifié
            return null; // ou retourner une réponse HTTP correspondante
        }
    }

    @PutMapping("/users/{userId}/events/{eventId}")
    public Event updateEventForUser(@PathVariable Long userId, @PathVariable Long eventId, @RequestBody Event event) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            event.setUser(user);
            return eventService.updateEvent(eventId, event);
        } else {
            // Gérer le cas où l'utilisateur n'existe pas pour l'ID spécifié
            return null; // ou retourner une réponse HTTP correspondante
        }
    }

    @DeleteMapping("/users/{userId}/events/{eventId}")
    public void deleteEventForUser(@PathVariable Long userId, @PathVariable Long eventId) {
        eventService.deleteEventById(eventId);
    }
}