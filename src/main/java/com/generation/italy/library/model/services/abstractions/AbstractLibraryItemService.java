package com.generation.italy.library.model.services.abstractions;

public interface AbstractLibraryItemService {
    void assignBookToUser(Integer userId, long bookId);
}
