package com.generation.italy.library.model.services.abstractions;

import com.generation.italy.library.dtos.LibraryItemDto;
import com.generation.italy.library.dtos.UserDto;
import com.generation.italy.library.model.entities.LibraryItem;

import java.security.Principal;
import java.util.List;

public interface AbstractUserService {

    UserDto getUserProfile(Principal connectedUser);

    List<LibraryItem> getLibrary(Integer id);



}
