package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryItemRepository extends JpaRepository<LibraryItem, Long> {

    boolean existsByUserAndBook(User user, Book book);

}
