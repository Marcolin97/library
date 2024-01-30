package com.generation.italy.library.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @Column(name = "feedback_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "publication_date")
    private LocalDate publication;

    public Feedback() {}

    public Feedback(long id, String comment, Long rating, LocalDate publication) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.publication = publication;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }
}
