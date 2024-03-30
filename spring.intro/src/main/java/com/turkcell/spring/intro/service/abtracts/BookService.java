package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.service.dtos.BookToAddDto;

import java.util.List;

public interface BookService {
    void add(BookToAddDto bookToAddDto);
    void delete(int id);
    void updateAvailabilty(int id);

    List<Book> list();
    Book getById(int id);
}
