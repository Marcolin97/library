package com.generation.italy.library.model.services.abstractions;

public interface AbstractLibraryItemService {
    void assignToBookUser(Integer userId, long bookId);
}
