package com.movies.api.domain;

import com.movies.api.domain.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "tb_movie")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE tb_movie SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class Movie extends BaseEntity {

    private String title;
    private String synopsis;

    @ManyToMany
    @JoinTable(
            name = "tb_movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<Director> directors;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String ageRating;

    private Double price;

    @OneToOne(cascade = CascadeType.ALL)
    private MovieDetails movieDetails;

}
