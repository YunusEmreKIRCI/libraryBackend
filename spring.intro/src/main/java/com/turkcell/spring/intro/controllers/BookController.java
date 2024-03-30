package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.service.abtracts.BookService;
import com.turkcell.spring.intro.service.dtos.BookToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping("/add")
    public void addBook(@RequestBody BookToAddDto book){
        bookService.add(book);
    }

    @GetMapping("/getbook")
    public Book getBook(int id){
        return bookService.getById(id);
    }

    @GetMapping("/delete")
    public void deleteBook(@RequestParam int id){
        bookService.delete(id);
    }

    @GetMapping("/update")
    public void updateBook(@RequestParam int id){
        bookService.updateAvailabilty(id);
    }
}
