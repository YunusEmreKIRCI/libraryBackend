package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.borrow.AddBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.DeleteBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.UpdateBorrowResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BorrowMapper {
    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "userId", target = "user.id")
    Borrow mapToBorrow(AddBorrowRequest borrowRequest);
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    GetBorrowResponse mapToBorrowResponse(Borrow borrow);
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    UpdateBorrowResponse mapToUpdateBorrowResponse(Borrow borrow);
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    DeleteBorrowResponse mapToDeleteBorrowResponse(Borrow borrow);
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    AddBorrowResponse mapToAddBorrowResponse(Borrow save);
    List<GetBorrowResponse> mapToBorrowResponseList(List<Borrow> borrows);


}
