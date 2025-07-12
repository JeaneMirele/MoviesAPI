package com.movies.api.dto;

import com.movies.api.controller.DirectorController;
import com.movies.api.controller.MovieController;
import com.movies.api.domain.Award;
import com.movies.api.domain.Director;
import com.movies.api.domain.MovieDetails;
import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDetailsDto extends RepresentationModel< MovieDetailsDto> {

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

    public void loadLinks(MovieDetails movieDetails) {
        this.add(WebMvcLinkBuilder.linkTo(MovieController.class).slash(movieDetails.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(MovieController.class).withRel("movie"));
        this.add(WebMvcLinkBuilder.linkTo(MovieController.class).slash(movieDetails.getId()).withRel("delete"));
    }
}
