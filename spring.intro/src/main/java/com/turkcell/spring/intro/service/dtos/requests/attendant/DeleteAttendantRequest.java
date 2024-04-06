package com.turkcell.spring.intro.service.dtos.requests.attendant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAttendantRequest {
    @NotBlank
    private int id;
}
