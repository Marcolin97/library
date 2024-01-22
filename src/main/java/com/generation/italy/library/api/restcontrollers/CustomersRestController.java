package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.model.entities.Customers;
import com.generation.italy.library.model.services.implementations.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomersRestController {
    LibraryService libraryService;
    @Autowired
    CustomersRestController(LibraryService libraryService){
        this.libraryService = libraryService;
    }
    @GetMapping("/")
    public List<Customers> getAllCustomers() {
        return libraryService.getAllCustomers();
    }
}
