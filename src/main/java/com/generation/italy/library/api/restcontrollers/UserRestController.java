package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.dtos.ChangePasswordRequestDto;
import com.generation.italy.library.dtos.LibraryItemDto;
import com.generation.italy.library.dtos.UserDto;
import com.generation.italy.library.model.entities.LibraryItem;
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
        if(userDto == null){
            return ResponseEntity.badRequest().build();
        }
        List<LibraryItem> books = service.getLibrary(userDto.getId());
        userDto.setLibraryItemDtos(books.stream().map(LibraryItemDto::new).toList());
            return ResponseEntity.ok(userDto);
    }

}
