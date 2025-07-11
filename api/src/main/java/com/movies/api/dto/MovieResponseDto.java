package com.movies.api.dto;

import com.movies.api.controller.DirectorController;
import com.movies.api.controller.MovieController;
import com.movies.api.domain.Director;
import com.movies.api.domain.Movie;
import com.movies.api.domain.enums.Genre;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponseDto extends RepresentationModel<MovieResponseDto> {
    private Long id;
    private String title;
    private String synopsis;
    private List<DirectorResponseDto> directors;
    private Genre genre;
    private Double price;
    private String ageRating;

    public void loadLinks(Movie movie) {
        this.add(WebMvcLinkBuilder.linkTo(MovieController.class).slash(movie.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(MovieController.class).withRel("movie"));
        this.add(WebMvcLinkBuilder.linkTo(MovieController.class).slash(movie.getId()).withRel("delete"));
    }
}
