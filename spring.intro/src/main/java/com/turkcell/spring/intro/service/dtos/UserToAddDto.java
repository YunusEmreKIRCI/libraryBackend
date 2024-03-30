package com.turkcell.spring.intro.service.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserToAddDto {
    private String email;
    private String password;



}
