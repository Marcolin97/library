package com.generation.italy.library.model.entities;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class BookMark {
    private Long page;
    private LocalDate lastRead;

    public BookMark(){}

    public BookMark(Long page, LocalDate checkDate) {
        this.page = page;
        this.lastRead = checkDate;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public LocalDate getLastRead() {
        return lastRead;
    }

    public void setLastRead(LocalDate lastRead) {
        this.lastRead = lastRead;
    }
}
