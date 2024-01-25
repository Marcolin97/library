package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.repositories.abstractions.AuthorRepository;
import com.generation.italy.library.model.repositories.abstractions.BooksRepository;
import com.generation.italy.library.model.repositories.abstractions.UserRepository;
import com.generation.italy.library.model.repositories.abstractions.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private AuthorRepository authorRepository;
    private BooksRepository booksRepository;
    private GenreRepository genreRepository;
    private UserRepository userRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository,
                          BooksRepository booksRepository,
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
}
