package com.turkcell.spring.intro.service.dtos.requests.book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    private String name;
    private boolean isAvailable;


}