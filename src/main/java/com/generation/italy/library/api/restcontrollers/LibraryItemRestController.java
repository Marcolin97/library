package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.services.implementations.LibraryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
public class LibraryItemRestController {

    private final LibraryItemService libraryItemService;

    @Autowired
    public LibraryItemRestController(LibraryItemService libraryItemService) {
        this.libraryItemService = libraryItemService;
    }

    @PostMapping("/")
    public ResponseEntity<String> assignBookToUser (@RequestParam Long userId, @RequestParam long bookId) {
        Integer id = Math.toIntExact(userId);
        try{
            libraryItemService.assignBookToUser(id, bookId);
            return ResponseEntity.ok("tutto bene");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("non tutto bene" + e.getMessage());
        }
    }

}
