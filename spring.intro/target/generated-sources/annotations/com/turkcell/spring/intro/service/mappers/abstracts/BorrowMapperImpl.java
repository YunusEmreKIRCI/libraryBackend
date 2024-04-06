package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.entities.User;
import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.borrow.AddBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.DeleteBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.UpdateBorrowResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-06T05:02:10+0300",
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

        getBorrowResponse.setBookId( borrowBookId( borrow ) );
        getBorrowResponse.setUserId( borrowUserId( borrow ) );
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

    @Override
    public UpdateBorrowResponse mapToUpdateBorrowResponse(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }

        UpdateBorrowResponse updateBorrowResponse = new UpdateBorrowResponse();

        updateBorrowResponse.setBookId( borrowBookId( borrow ) );
        updateBorrowResponse.setUserId( borrowUserId( borrow ) );
        updateBorrowResponse.setId( borrow.getId() );
        if ( borrow.getBorrowDate() != null ) {
            updateBorrowResponse.setBorrowDate( DateTimeFormatter.ISO_LOCAL_DATE.format( borrow.getBorrowDate() ) );
        }
        if ( borrow.getReturnDate() != null ) {
            updateBorrowResponse.setReturnDate( DateTimeFormatter.ISO_LOCAL_DATE.format( borrow.getReturnDate() ) );
        }
        updateBorrowResponse.setReturned( borrow.isReturned() );
        updateBorrowResponse.setLate( borrow.isLate() );

        return updateBorrowResponse;
    }

    @Override
    public DeleteBorrowResponse mapToDeleteBorrowResponse(Borrow borrow) {
        if ( borrow == null ) {
            return null;
        }

        DeleteBorrowResponse deleteBorrowResponse = new DeleteBorrowResponse();

        deleteBorrowResponse.setBookId( borrowBookId( borrow ) );
        deleteBorrowResponse.setUserId( borrowUserId( borrow ) );
        deleteBorrowResponse.setId( borrow.getId() );
        if ( borrow.getBorrowDate() != null ) {
            deleteBorrowResponse.setBorrowDate( DateTimeFormatter.ISO_LOCAL_DATE.format( borrow.getBorrowDate() ) );
        }
        if ( borrow.getReturnDate() != null ) {
            deleteBorrowResponse.setReturnDate( DateTimeFormatter.ISO_LOCAL_DATE.format( borrow.getReturnDate() ) );
        }
        deleteBorrowResponse.setReturned( borrow.isReturned() );
        deleteBorrowResponse.setLate( borrow.isLate() );

        return deleteBorrowResponse;
    }

    @Override
    public AddBorrowResponse mapToAddBorrowResponse(Borrow save) {
        if ( save == null ) {
            return null;
        }

        AddBorrowResponse addBorrowResponse = new AddBorrowResponse();

        addBorrowResponse.setBookId( borrowBookId( save ) );
        addBorrowResponse.setUserId( borrowUserId( save ) );
        addBorrowResponse.setId( save.getId() );
        if ( save.getBorrowDate() != null ) {
            addBorrowResponse.setBorrowDate( DateTimeFormatter.ISO_LOCAL_DATE.format( save.getBorrowDate() ) );
        }
        if ( save.getReturnDate() != null ) {
            addBorrowResponse.setReturnDate( DateTimeFormatter.ISO_LOCAL_DATE.format( save.getReturnDate() ) );
        }

        return addBorrowResponse;
    }

    @Override
    public List<GetBorrowResponse> mapToBorrowResponseList(List<Borrow> borrows) {
        if ( borrows == null ) {
            return null;
        }

        List<GetBorrowResponse> list = new ArrayList<GetBorrowResponse>( borrows.size() );
        for ( Borrow borrow : borrows ) {
            list.add( mapToBorrowResponse( borrow ) );
        }

        return list;
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

    private int borrowBookId(Borrow borrow) {
        if ( borrow == null ) {
            return 0;
        }
        Book book = borrow.getBook();
        if ( book == null ) {
            return 0;
        }
        int id = book.getId();
        return id;
    }

    private int borrowUserId(Borrow borrow) {
        if ( borrow == null ) {
            return 0;
        }
        User user = borrow.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }
}
