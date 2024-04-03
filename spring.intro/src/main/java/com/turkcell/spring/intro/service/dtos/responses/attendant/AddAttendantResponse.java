package com.turkcell.spring.intro.service.dtos.responses.attendant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAttendantResponse {
    private int id;
    private String email;
}
