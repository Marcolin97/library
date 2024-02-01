package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.id = :authorId")
    //SQL: "SELECT b.* FROM book b JOIN author_book ab ON b.book_id = ab.book_id WHERE ab.author_id = :authorId"
    List<Book> findByAuthorId(long authorId);

    List<Book> findByGenreId(long id);

    List<Book> findByTitleContainingIgnoreCase(String title);
}
