package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
