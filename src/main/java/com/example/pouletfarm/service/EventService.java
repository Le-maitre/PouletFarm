package com.example.pouletfarm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pouletfarm.model.Event;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
    public Event updateEvent(Long id, Event newEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setNom(newEvent.getNom());
            existingEvent.setDateEvent(newEvent.getDateEvent());
            return eventRepository.save(existingEvent);
        } else {
            // Gérer l'absence de l'événement avec cet identifiant
            return null;
        }
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    public List<Event> getAllEventsForUser(User user) {
        // Récupérer tous les événements associés à un utilisateur donné
        return eventRepository.findByUser(user);
    }

    public Event getEventForUserById(User user, Long eventId) {
        // Récupérer un événement spécifique associé à un utilisateur donné par ID
        Optional<Event> event = eventRepository.findByUserAndId(user, eventId);
        return event.orElse(null);
    }
    public void deleteEventById(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}

