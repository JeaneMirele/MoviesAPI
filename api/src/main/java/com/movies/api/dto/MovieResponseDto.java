package com.movies.api.dto;

import com.movies.api.domain.enums.Genre;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponseDto {
    private Long id;
    private String title;
    private String synopsis;
    private List<DirectorResponseDto> directors;
    private Genre genre;
    private Double price;
    private String ageRating;
}
