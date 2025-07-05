package com.movies.api.dto;

import com.movies.api.domain.Genre;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponseDto {
    private Long id;
    private String title;
    private String synopsis;
    private String directorName;
    private Genre genre;
    private Double price;
    private String ageRating;
}
