package com.example.pouletfarm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pouletfarm.model.Event;
import com.example.pouletfarm.model.User;
@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
     List<Event> findByUser(User user);
     
    Optional<Event> findByUserAndId(User user, Long id);
}
