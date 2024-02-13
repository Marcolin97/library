package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.dtos.*;
import com.generation.italy.library.model.entities.*;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import com.generation.italy.library.model.repositories.abstractions.*;
import com.generation.italy.library.model.services.abstractions.LibraryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.generation.italy.library.model.repositories.abstractions.TokenRepository;
import com.generation.italy.library.model.repositories.abstractions.UserRepository;
import com.generation.italy.library.model.entities.User;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.*;

@Service
public class JPALibraryService implements LibraryService {
    private UserRepository        repository;
    private PasswordEncoder       passwordEncoder;
    private AuthorRepository      authorRepository;
    private BookRepository        bookRepository;
    private GenreRepository       genreRepository;
    private LibraryItemRepository libraryItemRepository;
    private TokenRepository       tokenRepository;
    private UserRepository        userRepository;
    private AuthenticationManager authenticationManager;
    @Autowired
    public JPALibraryService(AuthorRepository authorRepository,
                             BookRepository bookRepository,
                             GenreRepository genreRepository,
                             LibraryItemRepository libraryItemRepository,
                             TokenRepository tokenRepository,
                             UserRepository userRepository,
                             PasswordEncoder passwordEncoder,
                             AuthenticationManager authenticationManager){
        this.authorRepository       = authorRepository;
        this.bookRepository         = bookRepository;
        this.genreRepository        = genreRepository;
        this.libraryItemRepository  = libraryItemRepository;
        this.tokenRepository        = tokenRepository;
        this.userRepository         = userRepository;
        this.passwordEncoder        = passwordEncoder;
        this.repository             = userRepository;
        this.authenticationManager  = authenticationManager;
    }

    public void changePassword(ChangePasswordRequestDto request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }



    @Override
    public void assignBookToUser(Integer userId, long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + bookId));
        if (libraryItemRepository.existsByUserAndBook(user, book)) {
            throw new IllegalStateException("The book is already on your list.");
        } else {
            LibraryItem libraryItem = new LibraryItem();
            libraryItem.setUser(user);
            libraryItem.setBook(book);
            libraryItemRepository.save(libraryItem);
        }
    }

    @Override
    public List<Book> getBooksByAuthor(long id) throws NoSuchEntityException {
        Optional<Author> optA = authorRepository.findById(id);
        if (optA.isEmpty()){
            throw new NoSuchEntityException("Attempt to search for books by non-existent author", Author.class);
        }
        List<Book> books = bookRepository.findByAuthorId(id);
        return books;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Genre> getAllGenres() {
        return  genreRepository.findAll();
    }

    @Override
    public List<Book> getBooksByGenre(long id) throws NoSuchEntityException {
        Optional<Genre> optG = genreRepository.findById(id);
        if (optG.isEmpty()){
            throw new NoSuchEntityException("Attempting to search for genres for non-existent id", Genre.class);
        }
        List<Book> books = bookRepository.findByGenreId(id);
        return books;
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Author> getAuthorByName(String part) {
        return authorRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(part, part);
    }

    @Override
    public Optional<Book> findBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<LibraryItem> getLibrary(Integer id) {
        return repository.getLibrary(id);
    }
    public UserDto getUserProfile(Principal connectedUser) {
        User user = repository.findByEmail(connectedUser.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDto(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<LibraryItem> deleteLibraryItem(long id) {
        Optional<LibraryItem> lb = libraryItemRepository.findById(id);
        lb.ifPresent(l -> libraryItemRepository.delete(l));
        return lb;
    }



}
