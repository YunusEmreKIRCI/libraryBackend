package com.turkcell.spring.intro.service.dtos;

import com.turkcell.spring.intro.entities.Book;
import com.turkcell.spring.intro.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowToAddDto {
    private int userId;
    private int bookId;
}
