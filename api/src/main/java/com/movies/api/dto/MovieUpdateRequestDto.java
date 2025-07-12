package com.movies.api.dto;

import com.movies.api.domain.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Getter
@Setter
public class MovieUpdateRequestDto {
    @NotNull(message = "Id is required.")
    private Long id;
    @NotBlank( message = "Title is required.")
    private String title;
    @NotBlank(message = "Synopsis is required.")
    private String synopsis;
    @NotNull(message = "Genre is required.")
    private Genre genre;
    @NotNull
    private Double price;
    @NotBlank(message = "Age rating is required.")
    private String ageRating;
}
