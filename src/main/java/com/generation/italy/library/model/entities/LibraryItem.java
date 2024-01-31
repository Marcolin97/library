package com.generation.italy.library.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_books")
public class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @Embedded
    private BookMark bookMark;
    public LibraryItem() {}

    public LibraryItem(Long Id, User user, Book book) {
        this.Id = Id;
        this.user = user;
        this.book = book;
    }

    public Long getAssignmentId() {
        return Id;
    }

    public void setAssignmentId(Long assignmentId) {
        this.Id = assignmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
