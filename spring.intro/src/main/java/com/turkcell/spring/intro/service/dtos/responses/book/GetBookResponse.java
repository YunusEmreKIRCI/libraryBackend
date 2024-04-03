package com.turkcell.spring.intro.service.dtos.responses.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBookResponse {
    private int id;
    private String name;
    private boolean isAvailable;
}
