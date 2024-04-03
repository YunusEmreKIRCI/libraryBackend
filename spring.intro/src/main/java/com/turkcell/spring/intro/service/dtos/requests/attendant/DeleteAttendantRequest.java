package com.turkcell.spring.intro.service.dtos.requests.attendant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAttendantRequest {
    private int id;
}
