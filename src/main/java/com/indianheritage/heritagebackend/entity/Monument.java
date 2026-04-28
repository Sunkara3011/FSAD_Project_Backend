package com.indianheritage.heritagebackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private String category;
    private String imageUrl;

    @Column(length = 2000)
    private String description;

    private Double rating;
}