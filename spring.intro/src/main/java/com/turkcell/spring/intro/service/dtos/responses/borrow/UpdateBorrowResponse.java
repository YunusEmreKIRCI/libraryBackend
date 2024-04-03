package com.turkcell.spring.intro.service.dtos.responses.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBorrowResponse {
    private int id;
    private int userId;
    private int bookId;
    private String borrowDate;
    private String returnDate;
    private boolean isReturned;
    private boolean isLate;
}
