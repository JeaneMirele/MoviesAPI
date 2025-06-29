package com.movies.api.services;

import com.movies.api.services.generic.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class MovieDetailsService extends AbstractService<MovieDetailsService, Long, MovieDetailsRepository> {

    public MovieDetailsService(MovieDetailsRepository repository) {
        super(repository);
    }
}
