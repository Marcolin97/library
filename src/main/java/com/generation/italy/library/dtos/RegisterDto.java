package com.generation.italy.library.dtos;

import com.generation.italy.library.model.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
