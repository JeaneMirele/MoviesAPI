package com.movies.api.dto;

import com.movies.api.domain.Award;
import com.movies.api.domain.Genre;
import com.movies.api.domain.MovieDetails;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@Getter
@Setter
public class MovieSaveRequestDto {
    @NotBlank( message = "Title is required.")
    private String title;
    @NotBlank(message = "Synopsis is required.")
    private String synopsis;
    @NotEmpty(message = "At least one director is required.")
    private List<DirectorIdDto> directors;
    @NotNull(message = "Genre is required.")
    private Genre genre;
    @NotNull
    private Double price;
    @NotBlank(message = "Age rating is required.")
    private String ageRating;
    @NotNull(message = "Movie details are required.")
    private MovieDetailsDto movieDetails;

}
