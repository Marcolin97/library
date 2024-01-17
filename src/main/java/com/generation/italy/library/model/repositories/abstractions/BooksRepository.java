package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
