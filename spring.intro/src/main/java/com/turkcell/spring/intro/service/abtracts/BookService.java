package com.turkcell.spring.intro.service.abtracts;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.service.dtos.BookToAddDto;
import com.turkcell.spring.intro.service.dtos.requests.book.AddBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.DeleteBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.GetBookRequest;
import com.turkcell.spring.intro.service.dtos.requests.book.UpdateBookRequest;
import com.turkcell.spring.intro.service.dtos.responses.book.AddBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.DeleteBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.GetBookResponse;
import com.turkcell.spring.intro.service.dtos.responses.book.UpdateBookResponse;

import java.util.List;

public interface BookService {
    AddBookResponse add(AddBookRequest request);
    DeleteBookResponse delete(DeleteBookRequest request);
    UpdateBookResponse updateAvailabilty(UpdateBookRequest request);

    List<GetBookResponse> list();
    GetBookResponse getById(GetBookRequest request);
}
