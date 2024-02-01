package com.generation.italy.library.dtos;

public class GenreDto {
    private Long id;
    private String genre;

    public GenreDto() {}

    public GenreDto(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
