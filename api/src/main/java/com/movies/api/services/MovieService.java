package com.movies.api.services;

import com.movies.api.domain.Movie;
import com.movies.api.dto.MovieDetailsDto;
import com.movies.api.dto.MovieUpdateRequestDto;
import com.movies.api.mapper.AwardMapper;
import com.movies.api.repositorys.MovieRepository;
import com.movies.api.services.generic.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends AbstractService<Movie, Long, MovieRepository> {
    private final AwardMapper awardMapper;
    public MovieService(MovieRepository repository, AwardMapper awardMapper) {
        super(repository);
        this.awardMapper = awardMapper;
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

    public Movie updateMovieDetailsByMovieId(Long movieId, MovieDetailsDto dto) {
        var movie = super.repository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found."));

        var movieDetails = movie.getMovieDetails();
        movieDetails.setDetailedSynopsis(dto.getDetailedSynopsis());
        movieDetails.setRate(dto.getRate());
        movieDetails.setReleaseDate(dto.getReleaseDate());
        movieDetails.setTrailerUrl(dto.getTrailerUrl());
        var awards = movieDetails.getAwards();
        awards.clear();
        dto.getAwards().stream()
            .map(awardMapper::toEntity)
            .forEach(awards::add);

        return super.repository.save(movie);
    }

}
