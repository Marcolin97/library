package com.generation.italy.library.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "book_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genres genres;
    @ManyToOne
    @JoinColumn(name = "feedback_id", nullable = false)
    private Feedback feedback;
    @Column(name = "title")
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
    private long price;
    @Column(name = "description")
    private String description;

    public  Books() {}

    public Books(Long id, Author author, Genres genres, Feedback feedback, String title, LocalDate publicationYear, String editor, String publisher, long pages, long price, String description) {
        this.id = id;
        this.author = author;
        this.genres = genres;
        this.feedback = feedback;
        this.title = title;
        this.publicationYear = publicationYear;
        this.editor = editor;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
