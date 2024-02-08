package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.Author;
import com.generation.italy.library.model.entities.Book;
import com.generation.italy.library.model.entities.Feedback;
import com.generation.italy.library.model.entities.Genre;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

public class BookDto {
    private Long id;
    private String authorFirstName;
    private String authorLastName;
    private String title;
    private LocalDate publicationYear;
    private String editor;
    private String publisher;
    private long  pages;
    private Long price;
    private String description;
    private String img;

    public BookDto() {}

//    public BookDto(Long id, String authorFirstName,
//                   String authorLastName, String title,
//                   LocalDate publicationYear, String editor,
//                   String publisher, long pages,
//                   Long price, String description, String img) {
//        this.id = id;
//        this.authorFirstName = authorFirstName;
//        this.authorLastName = authorLastName;
//        this.title = title;
//        this.publicationYear = publicationYear;
//        this.editor = editor;
//        this.publisher = publisher;
//        this.pages = pages;
//        this.price = price;
//        this.description = description;
//        this.img = img;
//    }

    public BookDto(Book book){
        this.id = book.getId();
        this.authorFirstName = getAuthorFirstName();
        this.authorLastName = getAuthorLastName();
        this.title = book.getTitle();
        this.publicationYear = book.getPublicationYear();
        this.editor = book.getEditor();
        this.publisher = book.getPublisher();
        this.pages = book.getPages();
        this.price = book.getPrice();
        this.description = book.getDescription();
        this.img = book.getImg();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
