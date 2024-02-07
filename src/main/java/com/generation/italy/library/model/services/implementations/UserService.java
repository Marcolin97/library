package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.dtos.ChangePasswordRequestDto;
import com.generation.italy.library.dtos.UserDto;
import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.repositories.abstractions.AuthorRepository;
import com.generation.italy.library.model.repositories.abstractions.BookRepository;
import com.generation.italy.library.model.repositories.abstractions.GenreRepository;
import com.generation.italy.library.model.repositories.abstractions.UserRepository;
import com.generation.italy.library.model.services.abstractions.AbstractUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService implements AbstractUserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository repository, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void changePassword(ChangePasswordRequestDto request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }

    public UserDto getUserProfile(Principal connectedUser) {
        User user = userRepository.findByEmail(connectedUser.getName()).orElseThrow(() -> new UsernameNotFoundException("utente non trovato"));
        return new UserDto(user);
    }

}
