package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.Genre;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import com.generation.italy.library.model.services.abstractions.AbstractLibraryService;
import com.generation.italy.library.model.services.implementations.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@CrossOrigin
public class GenreRestController {
    private AbstractLibraryService libraryService;

    @Autowired
    GenreRestController(AbstractLibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public List<Genre> getAllGenres() {
        return libraryService.getAllGenres();
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<?> getBooksByGenreId(@PathVariable long id) {
        try {
            List<Book> result = libraryService.getBooksByGenre(id);
            return ResponseEntity.ok(result);
        } catch (NoSuchEntityException e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
