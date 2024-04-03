package com.turkcell.spring.intro.service.dtos.responses.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBookResponse {
    int id;
    String name;
    boolean isAvailable;
}
