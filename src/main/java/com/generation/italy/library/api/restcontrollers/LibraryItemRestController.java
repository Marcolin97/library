package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.dtos.LibraryItemDto;
import com.generation.italy.library.dtos.UserDto;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.services.abstractions.LibraryService;
import com.generation.italy.library.model.services.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class LibraryItemRestController {

    private final LibraryService libraryService;
    private final UserService userService;


    @Autowired
    public LibraryItemRestController(LibraryService libraryItemService, UserService userService) {
        this.libraryService = libraryItemService;
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<String> assignBookToUser (@RequestParam Long userId, @RequestParam long bookId) {
        Integer id = Math.toIntExact(userId);
        try{
            libraryService.assignBookToUser(id, bookId);
            return ResponseEntity.ok("Everything OK");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Not all good" + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<LibraryItemDto>> getLibrary(@PathVariable Integer id) {
        User user = userService.getUserProfile(id);
        List<LibraryItem> books = userService.getLibrary(user.getId());
        List<LibraryItemDto> library = books.stream().map(LibraryItemDto::new).toList();
        return ResponseEntity.ok(library);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeBook(@PathVariable long id){
        Optional<LibraryItem> result = libraryService.deleteLibraryItem(id);
        return result.stream()
                .map(lb -> ResponseEntity.ok().build())
                .findFirst()
                .orElse(ResponseEntity.notFound().build());
    }

}