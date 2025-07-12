package com.movies.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientSaveRequestDto {
    @NotBlank(message = "Name is required.")
    private String name;
    private Boolean isAdmin = false;
    @NotNull(message = "Birthday is required.")
    private LocalDate birthday;
    @NotBlank(message = "Username is required.")
    private String username;
    @NotBlank(message = "Password is required.")
    private String password;
}
