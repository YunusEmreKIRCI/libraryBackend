package com.turkcell.spring.intro.service.dtos.responses.attendant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAttendantResponse {
    private String email;
    private String password;

    public void setId(int id) {
    }
}
