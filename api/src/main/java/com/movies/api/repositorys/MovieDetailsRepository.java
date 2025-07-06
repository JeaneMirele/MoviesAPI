package com.movies.api.repositorys;

import com.movies.api.domain.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long> {
}
