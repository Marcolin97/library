package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.LibraryItem;
import com.generation.italy.library.model.entities.User;

import java.util.List;

public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private List<LibraryItemDto> libraryItemDtos;

    public UserDto() {}

    public UserDto(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole().toString();
    }
    public UserDto(User user, List<LibraryItem> lb) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole().toString();
        this.libraryItemDtos = lb.stream().map(LibraryItemDto::new).toList();
    }

    public List<LibraryItemDto> getLibraryItemDtos() {
        return libraryItemDtos;
    }

    public void setLibraryItemDtos(List<LibraryItemDto> libraryItemDtos) {
        this.libraryItemDtos = libraryItemDtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
