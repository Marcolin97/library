package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.services.implementations.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User")
@CrossOrigin
public class UserRestController {
    LibraryService libraryService;
    @Autowired
    UserRestController(LibraryService libraryService){
        this.libraryService = libraryService;
    }
    @GetMapping("/")
    public List<User> getAllUser() {
        return libraryService.getAllUser();
    }
}
