package com.movies.api.services;

import com.movies.api.domain.MovieDetails;
import com.movies.api.repositorys.MovieDetailsRepository;
import com.movies.api.services.generic.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class MovieDetailsService extends AbstractService<MovieDetails, Long, MovieDetailsRepository> {

    public MovieDetailsService(MovieDetailsRepository repository) {
        super(repository);
    }
}
