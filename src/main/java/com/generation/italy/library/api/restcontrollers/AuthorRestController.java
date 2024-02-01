package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import com.generation.italy.library.model.services.abstractions.AbstractLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin
public class AuthorRestController {
    private AbstractLibraryService libraryService;
    @Autowired
    public AuthorRestController(AbstractLibraryService libraryService){
        this.libraryService = libraryService;
    }
    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<?> getBooksByAuthorId(@PathVariable long id) {
        try {
            List<Book> result = libraryService.getBooksByAuthor(id);
            return ResponseEntity.ok(result);
        } catch (NoSuchEntityException e) {
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name")
    public ResponseEntity<List<Author>> getAuthorByName(@RequestParam String name1, @RequestParam String name2){
        List<Author> result = libraryService.getAuthorByName(name1, name2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
