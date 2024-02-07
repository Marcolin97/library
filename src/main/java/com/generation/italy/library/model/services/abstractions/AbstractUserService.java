package com.generation.italy.library.model.services.abstractions;

import com.generation.italy.library.dtos.UserDto;

import java.security.Principal;

public interface AbstractUserService {

    UserDto getUserProfile(Principal connectedUser);

}
