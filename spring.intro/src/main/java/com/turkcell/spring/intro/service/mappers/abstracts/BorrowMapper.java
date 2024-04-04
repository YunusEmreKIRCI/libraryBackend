package com.turkcell.spring.intro.service.mappers.abstracts;

import com.turkcell.spring.intro.entities.Borrow;
import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowMapper {
    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "userId", target = "user.id")
    Borrow mapToBorrow(AddBorrowRequest borrowRequest);
    GetBorrowResponse mapToBorrowResponse(Borrow borrow);
}
