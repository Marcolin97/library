package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
