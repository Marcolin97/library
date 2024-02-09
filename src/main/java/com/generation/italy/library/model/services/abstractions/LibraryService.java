package com.generation.italy.library.model.services.abstractions;

import com.generation.italy.library.dtos.*;
import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.Genre;
import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface LibraryService {
    void assignBookToUser(Integer userId, long bookId);
    List<Book> getBooksByAuthor(long id) throws NoSuchEntityException;

    List<Author> getAllAuthors();
    List<Genre> getAllGenres();
    List<Book> getBooksByGenre(long id) throws NoSuchEntityException;
    List<Book> getBookByTitle(String title);
    List<Author> getAuthorByName(String part);
    Optional<Book> findBookById(long id);
    List<LibraryItem> getLibrary(Integer id);
    List<Book> getAllBooks();
    Optional<LibraryItem> deleteLibraryItem(long id);
}
