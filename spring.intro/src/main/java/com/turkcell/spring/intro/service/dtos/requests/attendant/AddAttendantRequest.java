package com.turkcell.spring.intro.service.dtos.requests.attendant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAttendantRequest {
    @NotBlank
    @Size(min = 3, max = 50)
    private String email;
    @NotBlank(message = "password boş olamaz")
    @Size(min = 3, max = 50)
    private String password;
}
