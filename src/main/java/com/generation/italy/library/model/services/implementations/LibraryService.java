package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.repositories.abstractions.AuthorRepository;
import com.generation.italy.library.model.repositories.abstractions.BooksRepository;
import com.generation.italy.library.model.repositories.abstractions.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private AuthorRepository authorRepository;
    private BooksRepository booksRepository;
    private GenreRepository genreRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository,
                          BooksRepository booksRepository,
                          GenreRepository genreRepository){
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
        this.genreRepository = genreRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
