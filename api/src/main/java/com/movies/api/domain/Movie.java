package com.movies.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_movie")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseEntity {

    @NotBlank( message = "Title is required.")
    private String title;
    @NotBlank(message = "Synopsis is required.")
    private String synopsis;

    @ManyToMany
    @JoinTable(
            name = "tb_movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    @NotEmpty(message = "At least one director is required.")
    private List<Director> directors;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Genre is required.")
    private Genre genre;

    @NotNull(message = "Age rating is required.")
    private String ageRating;

    @OneToOne(cascade = CascadeType.ALL)
    @NotBlank(message = "Movie details are required.")
    private MovieDetails movieDetails;

}
