package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.service.abtracts.BookService;
import com.turkcell.spring.intro.service.dtos.BookToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.book.AddBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.DeleteBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.GetBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.UpdateBookRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.AddBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.DeleteBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.UpdateBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<GetBookResponse>> getAll(){
        return ResponseEntity.ok(bookService.list());
    }

    @PostMapping("/add")
    public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookRequest request){
        return ResponseEntity.ok(bookService.add(request));
    }

    @GetMapping("/getbook")
    public ResponseEntity<GetBookResponse> getBook(GetBookRequest request){

        return ResponseEntity.ok(bookService.getById(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteBookResponse> deleteBook(@RequestParam DeleteBookRequest request){
        return ResponseEntity.ok(bookService.delete(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateBookResponse> updateBook(@RequestParam UpdateBookRequest request){
        return ResponseEntity.ok(bookService.updateAvailabilty(request));
    }
}
