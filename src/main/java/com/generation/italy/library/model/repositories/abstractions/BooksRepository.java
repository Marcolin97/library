package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Books, Long> {
    Optional<Book> findById(String isbn);

}