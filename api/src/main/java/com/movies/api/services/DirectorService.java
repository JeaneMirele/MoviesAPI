package com.movies.api.services;

import com.movies.api.domain.Director;
import com.movies.api.repositorys.DirectorRepository;
import com.movies.api.services.generic.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class DirectorService extends AbstractService<Director, Long, DirectorRepository> {
    public DirectorService(DirectorRepository repository) {
        super(repository);
    }
}
