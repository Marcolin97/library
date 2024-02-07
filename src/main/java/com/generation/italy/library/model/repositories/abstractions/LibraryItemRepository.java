package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.LibraryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryItemRepository extends JpaRepository<LibraryItem, Long> {

}
