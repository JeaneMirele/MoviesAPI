package com.movies.api.repositorys;

import com.movies.api.domain.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long> {
}
