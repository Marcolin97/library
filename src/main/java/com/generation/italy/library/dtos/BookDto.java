package com.generation.italy.library.dtos;

import jakarta.persistence.*;

import java.time.LocalDate;

public class BookDto {
    private Long id;
    private String authorFirstName;
    private String authorLastName;

    private String title;
    @Column(name = "publication_year")
    private LocalDate publicationYear;
    @Column(name = "editor")
    private String editor;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "pages")
    private long  pages;
    @Column(name = "price")
    private Long price;
    @Column(name = "description")
    private String description;
}
