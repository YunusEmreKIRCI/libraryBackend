package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.service.dtos.requests.book.AddBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.GetBookRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.AddBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.DeleteBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.UpdateBookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book mapToBook(AddBookRequest bookDto);
    GetBookResponse mapToBookResponse(Book book);

    UpdateBookResponse mapToUpdateBookResponse(Book book);

    DeleteBookResponse mapToDeleteBookResponse(Book book);

    List<GetBookResponse> mapToBookResponseList(List<Book> books);

    AddBookResponse mapToAddBookResponse(Book save);
}
