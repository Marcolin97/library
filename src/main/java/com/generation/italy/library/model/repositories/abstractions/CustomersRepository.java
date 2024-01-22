package com.generation.italy.library.model.repositories.abstractions;

import com.generation.italy.library.model.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
