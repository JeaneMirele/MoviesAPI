package com.movies.api.services;

import com.movies.api.domain.Movie;
import com.movies.api.dto.MovieUpdateRequestDto;
import com.movies.api.repositorys.MovieRepository;
import com.movies.api.services.generic.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends AbstractService<Movie, Long, MovieRepository> {

    public MovieService(MovieRepository repository) {
        super(repository);
    }

    public Movie update(MovieUpdateRequestDto dto) {
        var entity = super.repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Movie not found."));

        entity.setTitle(dto.getTitle());
        entity.setSynopsis(dto.getSynopsis());
        entity.setPrice(dto.getPrice());
        entity.setGenre(dto.getGenre());
        entity.setAgeRating(dto.getAgeRating());
        return super.repository.save(entity);
    }

}
