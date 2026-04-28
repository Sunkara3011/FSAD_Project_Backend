package com.indianheritage.heritagebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indianheritage.heritagebackend.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}