package com.indianheritage.heritagebackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.indianheritage.heritagebackend.entity.Monument;
import com.indianheritage.heritagebackend.repository.MonumentRepository;

@RestController
@RequestMapping("/api/monuments")
@CrossOrigin(origins = "*")
public class MonumentController {

    @Autowired
    private MonumentRepository monumentRepository;

    // Get all monuments
    @GetMapping
    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }

    // Get by id
    @GetMapping("/{id}")
    public Monument getById(@PathVariable Long id) {
        return monumentRepository.findById(id).orElse(null);
    }

    // Add monument
    @PostMapping
    public Monument addMonument(@RequestBody Monument monument) {
        return monumentRepository.save(monument);
    }

    // Update monument
    @PutMapping("/{id}")
    public Monument updateMonument(@PathVariable Long id, @RequestBody Monument updated) {
        Monument monument = monumentRepository.findById(id).orElse(null);

        if (monument != null) {
            monument.setName(updated.getName());
            monument.setState(updated.getState());
            monument.setCategory(updated.getCategory());
            monument.setDescription(updated.getDescription());
            monument.setImageUrl(updated.getImageUrl());
            monument.setRating(updated.getRating());

            return monumentRepository.save(monument);
        }

        return null;
    }

    // Delete monument
    @DeleteMapping("/{id}")
    public String deleteMonument(@PathVariable Long id) {
        monumentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    // Search by state
    @GetMapping("/state/{state}")
    public List<Monument> getByState(@PathVariable String state) {
        return monumentRepository.findByState(state);
    }

    // Search by category
    @GetMapping("/category/{category}")
    public List<Monument> getByCategory(@PathVariable String category) {
        return monumentRepository.findByCategory(category);
    }

    // Search by name
    @GetMapping("/search/{name}")
    public List<Monument> searchByName(@PathVariable String name) {
        return monumentRepository.findByNameContainingIgnoreCase(name);
    }
}