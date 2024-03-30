package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.repositories.BookRepository;
import com.turkcell.spring.intro.service.abtracts.BookService;
import com.turkcell.spring.intro.service.dtos.BookToAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void add(BookToAddDto bookToAddDto) {
        Book book = new Book();
        book.setName(bookToAddDto.getName());
        book.setAvailability(bookToAddDto.isAvailability());

        bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }
        else{
            bookRepository.delete(book);
        }
    }

    @Override
    public void updateAvailabilty(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }
        else{
            book.setAvailability(!book.isAvailability());
            bookRepository.save(book);
        }
    }


    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
