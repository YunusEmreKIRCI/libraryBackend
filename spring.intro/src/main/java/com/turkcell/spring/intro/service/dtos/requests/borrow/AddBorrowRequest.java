package com.turkcell.spring.intro.service.dtos.requests.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBorrowRequest {
    private int bookId;
    private int userId;
    private String borrowDate;
    private String returnDate;
}
