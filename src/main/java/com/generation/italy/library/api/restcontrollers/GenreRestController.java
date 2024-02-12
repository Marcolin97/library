package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.Genre;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import com.generation.italy.library.model.services.abstractions.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreRestController {
    private LibraryService libraryService;

    @Autowired
    GenreRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public List<Genre> getAllGenres() {
        return libraryService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooksByGenreId(@PathVariable long id) {
        try {
            List<Book> result = libraryService.getBooksByGenre(id);
            return ResponseEntity.ok(result);
        } catch (NoSuchEntityException e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
