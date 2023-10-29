package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
