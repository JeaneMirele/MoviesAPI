package com.movies.api.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Detailed synopsis is required.")
    private String detailesSynopsis;

    @NotNull(message = "Release time is required.")
    private LocalTime releaseDate;

    @NotBlank(message = "Trailer URL is required.")
    private String trailerUrl;

    @NotNull(message = "Rating is required.")
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be at most 10.")
    private Float rate;

    @OneToMany(mappedBy = "movieDetails")
    private List<Award> awards;

}
