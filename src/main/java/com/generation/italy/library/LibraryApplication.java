package com.generation.italy.library;

import com.generation.italy.library.dtos.RegisterRequestDto;
import com.generation.italy.library.model.entities.Role;
import com.generation.italy.library.model.services.implementations.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.generation.italy.library.model.entities.Role.ADMIN;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		System.out.println("Fabio manna è stato qui, ci dispiace");
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	) {
//		return args -> {
//			var admin = new RegisterRequestDto("Admin", "Admin", "admin@mail.com", "password", ADMIN);
//			System.out.println("Admin token: " + service.register(admin).getAccessToken());
//		};
//	}
}










