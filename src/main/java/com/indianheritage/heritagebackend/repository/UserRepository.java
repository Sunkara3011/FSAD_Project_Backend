package com.indianheritage.heritagebackend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.indianheritage.heritagebackend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}