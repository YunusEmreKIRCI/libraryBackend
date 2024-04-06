package com.turkcell.spring.intro.service.dtos.requests.borrow;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBorrowRequest {
    @NotBlank
    private int id;
}
