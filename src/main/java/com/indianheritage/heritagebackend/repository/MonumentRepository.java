package com.indianheritage.heritagebackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.indianheritage.heritagebackend.entity.Monument;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
    List<Monument> findByState(String state);
    List<Monument> findByCategory(String category);
    List<Monument> findByNameContainingIgnoreCase(String name);
}