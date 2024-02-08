package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.LibraryItem;

public class LibraryItemDto {
    private Integer userId;
    private Long bookId;
    private String title;
    //private String author;

    public LibraryItemDto() {}

    public LibraryItemDto(LibraryItem libraryItem) {
        this.userId = libraryItem.getUser().getId();
        this.bookId = libraryItem.getBook().getId();
        this.title = libraryItem.getBook().getTitle();
        //this.author = libraryItem.getBook().getAuthors();
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
}
