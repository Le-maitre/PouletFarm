package com.example.pouletfarm.repository;
import java.util.Optional;

import com.example.pouletfarm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
