package com.turkcell.spring.intro.service.concretes;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.repositories.BookRepository;
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
import com.turkcell.spring.intro.service.mappers.abstracts.AttendantMapper;
import com.turkcell.spring.intro.service.mappers.abstracts.BookMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private BookMapper bookMapper= Mappers.getMapper(BookMapper.class);
    @Override
    public AddBookResponse add(AddBookRequest request) {
        Book book = bookMapper.mapToBook(request);
        return bookMapper.mapToAddBookResponse(bookRepository.save(book));
    }

    @Override
    public DeleteBookResponse delete(DeleteBookRequest request) {
        Book book = bookRepository.findById(request.getId()).orElse(null);
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }
        else{
            bookRepository.delete(book);
            return bookMapper.mapToDeleteBookResponse(book);
        }
    }

    @Override
    public UpdateBookResponse updateAvailabilty(UpdateBookRequest request) {
        Book book = bookRepository.findById(request.getId()).orElse(null);
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }
        else{
            book.setAvailability(!book.isAvailability());
            return bookMapper.mapToUpdateBookResponse(bookRepository.save(book));
        }
    }


    @Override
    public List<GetBookResponse> list() {
        return bookMapper.mapToBookResponseList(bookRepository.findAll());
    }

    @Override
    public GetBookResponse getById(GetBookRequest request) {
        return bookMapper.mapToBookResponse(bookRepository.findById(request.getId()).orElse(null));
    }
}
