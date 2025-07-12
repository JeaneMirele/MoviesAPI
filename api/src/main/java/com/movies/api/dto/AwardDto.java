package com.movies.api.dto;

import com.movies.api.domain.MovieDetails;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class AwardDto {
    @NotBlank(message = "Title is required.")
    private String title;
    @NotBlank(message = "Description is required.")
    private String description;
    @NotNull(message = "Year is required.")
    private Long year;
}
