package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.Genre;
import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import com.generation.italy.library.model.repositories.abstractions.AuthorRepository;
import com.generation.italy.library.model.repositories.abstractions.BookRepository;
import com.generation.italy.library.model.repositories.abstractions.UserRepository;
import com.generation.italy.library.model.repositories.abstractions.GenreRepository;
import com.generation.italy.library.model.services.abstractions.AbstractLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService implements AbstractLibraryService {
    private AuthorRepository authorRepository;
    private BookRepository booksRepository;
    private GenreRepository genreRepository;
    private UserRepository userRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository,
                          BookRepository booksRepository,
                          GenreRepository genreRepository,
                          UserRepository userRepository){
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public List<Genre> getAllGenres() {
        return  genreRepository.findAll();
    }

    public List<Book> getBooksByAuthor(long id) throws NoSuchEntityException {
        Optional<Author> optA = authorRepository.findById(id);
        if (optA.isEmpty()){
            throw new NoSuchEntityException("Tentativo di ricerca di libri per autore inesistente", Author.class);
        }
        List<Book> books = booksRepository.findByAuthorId(id);
        return books;
    }

}
