package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);
    List<Author> findByNameIgnoreCaseContaining(String name);
}