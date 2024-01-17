package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}