package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.LibraryItem;

public class LibraryItemDto {
    private Long bookId;
    private String title;
    private String author;

    public LibraryItemDto() {}

    public LibraryItemDto(Long bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

//    public LibraryItemDto(LibraryItem libraryItem) {
//        this.bookId = libraryItem.getBook().getId();
//        this.title = libraryItem.getBook().getTitle();
//        this.author = libraryItem.getBook().getAuthors();
//    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
