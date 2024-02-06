package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.dtos.BookDto;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.services.implementations.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BookDto>> getBooks(@RequestParam(required = false)String title) {
        List<Book> books = null;
        if (title != null && !title.isEmpty()){
            books = libraryService.getBookByTitle(title);
        } else {
            books = libraryService.getAllBooks();
        }
        List<BookDto> dtos = books.stream().map(BookDto::new).toList();
        return ResponseEntity.ok(dtos);
    }

//    @GetMapping("/title")
//    public ResponseEntity<List<Book>> getBookByTitle(@RequestParam String title){
//        return ResponseEntity.ok(libraryService.getBookByTitle(title));
//    }
}
