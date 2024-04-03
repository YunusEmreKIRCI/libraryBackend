package com.turkcell.spring.intro.service.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserResponse {
    private int id;
    private String email;
}
