package com.movies.api.dto;

import com.movies.api.domain.Award;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDetailsDto {
    @NotBlank(message = "Detailed synopsis is required.")
    private String detailedSynopsis;
    @NotNull(message = "Release date is required.")
    private LocalDate releaseDate;
    @NotBlank(message = "Trailer URL is required.")
    private String trailerUrl;
    @NotNull(message = "Rating is required.")
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be at most 10.")
    private Float rate;
    private List<AwardDto> awards;
}
