package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.dtos.AuthorDto;
import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.exceptions.NoSuchEntityException;
import com.generation.italy.library.model.services.abstractions.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin
public class AuthorRestController {
    private LibraryService libraryService;
    @Autowired
    public AuthorRestController(LibraryService libraryService){
        this.libraryService = libraryService;
    }
    @GetMapping("/")
    public ResponseEntity<List<AuthorDto>> getAuthors(@RequestParam(required = false)String part) {
        List<Author> authors = null;
        if (part != null && !part.isEmpty()){
            authors = libraryService.getAuthorByName(part);
        } else{
            authors = libraryService.getAllAuthors();
        }
        List<AuthorDto> dtos = authors.stream().map(AuthorDto::new).toList();
        return ResponseEntity.ok(dtos);
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

}
