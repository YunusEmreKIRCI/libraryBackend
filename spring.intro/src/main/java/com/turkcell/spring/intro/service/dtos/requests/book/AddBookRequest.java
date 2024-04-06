package com.turkcell.spring.intro.service.dtos.requests.book;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    @NotBlank
    private String name;
    @NotBlank
    private boolean isAvailable;


}