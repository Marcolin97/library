package com.generation.italy.library.model.services.abstractions;

import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.Genre;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;

import java.util.List;

public interface AbstractLibraryService {
    List<Book> getBooksByAuthor(long id) throws NoSuchEntityException;

    List<Author> getAllAuthors();


    List<Genre> getAllGenres();

    List<Book> getBooksByGenre(long id) throws NoSuchEntityException;

    List<Book> getBookByTitle(String title);

    List<Author> getAuthorByName(String name1, String name2);

}
