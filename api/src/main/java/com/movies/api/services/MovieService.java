package com.movies.api.services;

import com.movies.api.domain.Movie;
import com.movies.api.repositorys.MovieRepository;
import com.movies.api.services.generic.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends AbstractService<Movie, Long, MovieRepository> {

    public MovieService(MovieRepository repository) {
        super(repository);
    }

}
