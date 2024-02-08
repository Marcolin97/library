package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.dtos.ChangePasswordRequestDto;
import com.generation.italy.library.dtos.LibraryItemDto;
import com.generation.italy.library.dtos.UserDto;
import com.generation.italy.library.model.services.implementations.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequestDto request, Principal connectedUser) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUserData(Principal connectedUser) {
        UserDto userDto = service.getUserProfile(connectedUser);
        return ResponseEntity.ok(userDto);
    }

//    @GetMapping("/")
//    public ResponseEntity<List<LibraryItemDto>> fetchAssignedBook(@RequestParam Long userId) {
//        List<LibraryItemDto> assignedBooks = service.fetchAssignedBook(userId);
//        return ResponseEntity.ok(assignedBooks);
//    }

}
