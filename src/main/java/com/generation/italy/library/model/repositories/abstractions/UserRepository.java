package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query("SELECT l FROM LibraryItem l WHERE l.user.id = :id")
    List<LibraryItem> getLibrary(Integer id);

}
