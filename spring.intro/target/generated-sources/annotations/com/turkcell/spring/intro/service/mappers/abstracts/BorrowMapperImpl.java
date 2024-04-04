package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-04T11:59:50+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class BorrowMapperImpl implements BorrowMapper {

    @Override
    public Borrow mapToBorrow(AddBorrowRequest borrowRequest) {
        if ( borrowRequest == null ) {
            return null;
        }

        Borrow borrow = new Borrow();

        borrow.setBook( addBorrowRequestToBook( borrowRequest ) );
        borrow.setUser( addBorrowRequestToUser( borrowRequest ) );
        if ( borrowRequest.getBorrowDate() != null ) {
            borrow.setBorrowDate( LocalDate.parse( borrowRequest.getBorrowDate() ) );
        }
        if ( borrowRequest.getReturnDate() != null ) {
            borrow.setReturnDate( LocalDate.parse( borrowRequest.getReturnDate() ) );
        }

        return borrow;
    }

    @Override
    public GetBorrowResponse mapToBorrowResponse(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }

        GetBorrowResponse getBorrowResponse = new GetBorrowResponse();

        getBorrowResponse.setId( borrow.getId() );
        if ( borrow.getBorrowDate() != null ) {
            getBorrowResponse.setBorrowDate( DateTimeFormatter.ISO_LOCAL_DATE.format( borrow.getBorrowDate() ) );
        }
        if ( borrow.getReturnDate() != null ) {
            getBorrowResponse.setReturnDate( DateTimeFormatter.ISO_LOCAL_DATE.format( borrow.getReturnDate() ) );
        }
        getBorrowResponse.setReturned( borrow.isReturned() );
        getBorrowResponse.setLate( borrow.isLate() );

        return getBorrowResponse;
    }

    protected Book addBorrowRequestToBook(AddBorrowRequest addBorrowRequest) {
        if ( addBorrowRequest == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( addBorrowRequest.getBookId() );

        return book;
    }

    protected User addBorrowRequestToUser(AddBorrowRequest addBorrowRequest) {
        if ( addBorrowRequest == null ) {
            return null;
        }

        User user = new User();

        user.setId( addBorrowRequest.getUserId() );

        return user;
    }
}
