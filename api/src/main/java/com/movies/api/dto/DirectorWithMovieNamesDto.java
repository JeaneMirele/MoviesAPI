package com.movies.api.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DirectorWithMovieNamesDto {
    private Long id;
    private String name;
    private List<String> movieTitles;
}
