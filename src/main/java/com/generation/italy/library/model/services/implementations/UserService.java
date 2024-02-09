package com.generation.italy.library.model.services.implementations;

import com.generation.italy.library.dtos.ChangePasswordRequestDto;
import com.generation.italy.library.dtos.UserDto;
import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.entities.User;
import com.generation.italy.library.model.repositories.abstractions.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository repository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.repository = userRepository;
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
        User user = repository.findByEmail(connectedUser.getName()).orElseThrow(() -> new UsernameNotFoundException("utente non trovato"));
        return new UserDto(user);
    }


    public List<LibraryItem> getLibrary(Integer id) {
        return repository.getLibrary(id);
    }

    public User getUserProfile(Integer id) {
        User user = repository.findById(id).get();
        return user;
    }

}
