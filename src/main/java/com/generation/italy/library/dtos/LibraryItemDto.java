package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.LibraryItem;

public class LibraryItemDto {
    private Long id;
    private Integer userId;
    private Long bookId;
    private String title;
    private String genre;
    private String editor;
    private String publisher;
    private long pages;
    private Long price;
    private String description;
    private String img;
    public LibraryItemDto() {}

    public LibraryItemDto(LibraryItem libraryItem) {
        this.id = libraryItem.getAssignmentId();
        this.userId = libraryItem.getUser().getId();
        this.bookId = libraryItem.getBook().getId();
        this.title = libraryItem.getBook().getTitle();
        this.genre = libraryItem.getBook().getGenre().getGenre();
        this.editor = libraryItem.getBook().getEditor();
        this.publisher = libraryItem.getBook().getPublisher();
        this.pages = libraryItem.getBook().getPages();
        this.price = libraryItem.getBook().getPrice();
        this.description = libraryItem.getBook().getDescription();
        this.img = libraryItem.getBook().getImg();
        //this.author = libraryItem.getBook().getAuthors();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
