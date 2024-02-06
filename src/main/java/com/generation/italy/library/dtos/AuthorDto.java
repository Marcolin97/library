package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.Author;

import java.time.LocalDate;

public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String nationality;
    private String info;

    public AuthorDto() {}

    public AuthorDto(Long id, String firstName, String lastName, LocalDate birthdate, String nationality, String info) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.info = info;
    }
    public AuthorDto (Author author){
        this.id= author.getId();
        this.firstName= author.getFirstName();
        this.lastName= author.getLastName();
        this.birthdate = author.getBirthdate();
        this.nationality = author.getNationality();
        this.info = author.getInfo();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
