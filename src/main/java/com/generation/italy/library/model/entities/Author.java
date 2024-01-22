package com.generation.italy.library.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author_name")
    private String name;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "info")
    private String info;

    public Author() {}

    public Author(Long id, String name, LocalDate birthdate, String nationality, String info) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
