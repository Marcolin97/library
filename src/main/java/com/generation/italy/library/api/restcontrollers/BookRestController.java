package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.services.implementations.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookRestController {
    LibraryService libraryService;

    @Autowired
    BookRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

}
