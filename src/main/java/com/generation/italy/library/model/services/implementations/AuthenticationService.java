package com.generation.italy.library.model.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation.italy.library.dtos.AuthenticationRequestDto;
import com.generation.italy.library.dtos.AuthenticationResponseDto;
import com.generation.italy.library.dtos.RegisterRequestDto;
import com.generation.italy.library.model.entities.Token;
import com.generation.italy.library.model.entities.TokenType;
import com.generation.italy.library.model.repositories.abstractions.TokenRepository;
import com.generation.italy.library.model.repositories.abstractions.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import com.generation.italy.library.model.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    public AuthenticationResponseDto register(RegisterRequestDto request) {
        var user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getRole()
        );
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        Date d = new Date(System.currentTimeMillis() + jwtExpiration);
        savedUserToken(savedUser, jwtToken);
        return  new AuthenticationResponseDto(jwtToken, refreshToken, user, d);
    }

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        Date d = new Date(System.currentTimeMillis() + jwtExpiration);
        savedUserToken(user, jwtToken);
        return new AuthenticationResponseDto(jwtToken, refreshToken, user, d);
    }

    private void savedUserToken(User user, String jwtToken) {
        var token = new Token(user, jwtToken, TokenType.BEARER, false, false);
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (!validUserTokens.isEmpty()) {
            validUserTokens.forEach(token -> {
                token.setExpired(true);
                token.setRevoked(true);
            });
            tokenRepository.saveAll(validUserTokens);
        }
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                savedUserToken(user, accessToken);
                Date d = new Date(System.currentTimeMillis() + jwtExpiration);
                var authResponse = new AuthenticationResponseDto(accessToken, refreshToken, user, d);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}

