package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.service.dtos.requests.book.GetBookRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.DeleteBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.UpdateBookResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-04T11:59:50+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book mapToBook(GetBookRequest bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );

        return book;
    }

    @Override
    public GetBookResponse mapToBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        GetBookResponse getBookResponse = new GetBookResponse();

        getBookResponse.setId( book.getId() );
        getBookResponse.setName( book.getName() );

        return getBookResponse;
    }

    @Override
    public UpdateBookResponse mapToUpdateBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        UpdateBookResponse updateBookResponse = new UpdateBookResponse();

        updateBookResponse.setId( book.getId() );
        updateBookResponse.setName( book.getName() );

        return updateBookResponse;
    }

    @Override
    public DeleteBookResponse mapToDeleteBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        DeleteBookResponse deleteBookResponse = new DeleteBookResponse();

        deleteBookResponse.setId( book.getId() );
        deleteBookResponse.setName( book.getName() );

        return deleteBookResponse;
    }

    @Override
    public List<GetBookResponse> mapToBookResponseList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<GetBookResponse> list = new ArrayList<GetBookResponse>( books.size() );
        for ( Book book : books ) {
            list.add( mapToBookResponse( book ) );
        }

        return list;
    }
}
