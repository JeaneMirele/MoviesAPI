package com.movies.api.dto;

import com.movies.api.controller.DirectorController;
import com.movies.api.domain.Director;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DirectorResponseDto extends RepresentationModel<DirectorResponseDto> {
    private Long id;
    private String name;

    public void loadLinks(Director director) {
        this.add(WebMvcLinkBuilder.linkTo(DirectorController.class).slash(director.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(DirectorController.class).withRel("director"));
        this.add(WebMvcLinkBuilder.linkTo(DirectorController.class).slash(director.getId()).withRel("delete"));
    }
}
