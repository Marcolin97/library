package com.generation.italy.library.api.restcontrollers;

import com.generation.italy.library.dtos.AuthenticationRequestDto;
import com.generation.italy.library.dtos.AuthenticationResponseDto;
import com.generation.italy.library.dtos.RegisterRequestDto;
import com.generation.italy.library.model.exceptions.EmailAlreadyExistsException;
import com.generation.italy.library.model.services.implementations.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto request) {
        try {
            AuthenticationResponseDto response = service.register(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmailAlreadyExistsException e) {
            return new ResponseEntity<>("L'indirizzo email è già in uso", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore durante la registrazione. Riprova.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(
            @RequestBody AuthenticationRequestDto request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}
