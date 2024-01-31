package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.Genre;
import com.generation.italy.library.model.services.implementations.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@CrossOrigin
public class GenreRestController {
    LibraryService libraryService;

    @Autowired
    GenreRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public List<Genre> getAllGenres() {
        return libraryService.getAllGenres();
    }
}
