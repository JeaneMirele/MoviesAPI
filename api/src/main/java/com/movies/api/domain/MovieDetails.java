package com.movies.api.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_movie_details")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE tb_movie_details SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class MovieDetails extends BaseEntity {
    private String detailedSynopsis;

    private LocalDate releaseDate;

    private String trailerUrl;

    private Float rate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_details_id", nullable = false)
    private List<Award> awards;
}
