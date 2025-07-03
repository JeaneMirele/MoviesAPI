package com.movies.api.services;

import com.movies.api.domain.Director;
import com.movies.api.services.generic.AbstractService;

public class DirectorService extends AbstractService<Director, Long, DirectorRepository> {
    public DirectorService(DirectorRepository repository) {
        super(repository);
    }
}
