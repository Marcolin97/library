package com.generation.italy.library.api.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/books")
public class StephenKingRestController {
    private final WebClient webClient;

    @Autowired
    public StephenKingRestController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://stephen-king-api.onrender.com/").build();
    }

    @GetMapping
    public Flux<Object> getAllBooks() {
        return webClient.get().uri("/api/books").retrieve().bodyToFlux(Object.class);
    }
}

