package com.movies.api.dto;

import com.movies.api.controller.DirectorController;
import com.movies.api.domain.Director;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DirectorWithMovieNamesDto extends RepresentationModel<DirectorWithMovieNamesDto> {
    private Long id;
    private String name;
    private List<String> movieTitles;

    public void loadLinks(Director director) {
        this.add(WebMvcLinkBuilder.linkTo(DirectorController.class).slash(director.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(DirectorController.class).withRel("director"));
        this.add(WebMvcLinkBuilder.linkTo(DirectorController.class).slash(director.getId()).withRel("delete"));
    }

}
