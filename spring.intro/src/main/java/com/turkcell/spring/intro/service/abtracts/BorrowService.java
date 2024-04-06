package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.service.dtos.requests.borrow.AddBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.DeleteBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.GetBorrowRequest;
import com.turkcell.spring.intro.service.dtos.requests.borrow.UpdateBorrowRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.AddBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.DeleteBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.GetBorrowResponse;
import com.turkcell.spring.intro.service.dtos.responses.borrow.UpdateBorrowResponse;

import java.util.List;

public interface BorrowService {
    AddBorrowResponse add(AddBorrowRequest request);
    DeleteBorrowResponse delete(DeleteBorrowRequest request);
    UpdateBorrowResponse update(UpdateBorrowRequest request);
    List<GetBorrowResponse> list();
    GetBorrowResponse getById(GetBorrowRequest request);
}
