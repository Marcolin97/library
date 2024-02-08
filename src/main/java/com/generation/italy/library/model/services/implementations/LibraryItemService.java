package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.repositories.abstractions.*;
import com.generation.italy.library.model.services.abstractions.AbstractLibraryItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryItemService implements AbstractLibraryItemService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;
    private UserRepository userRepository;
    private LibraryItemRepository libraryItemRepository;

    @Autowired
    public LibraryItemService(AuthorRepository authorRepository,
                          BookRepository bookRepository,
                          GenreRepository genreRepository,
                          UserRepository userRepository,
                          LibraryItemRepository libraryItemRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
        this.libraryItemRepository =  libraryItemRepository;
    }

    @Override
    public void assignBookToUser(Integer userId, long bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + bookId));
        LibraryItem libraryItem = new LibraryItem();
        libraryItem.setUser(user);
        libraryItem.setBook(book);
        libraryItemRepository.save(libraryItem);
    }
}
