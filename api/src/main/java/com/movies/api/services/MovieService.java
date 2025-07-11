package com.movies.api.services;

import com.movies.api.domain.Director;
import com.movies.api.domain.Movie;
import com.movies.api.dto.MovieDetailsDto;
import com.movies.api.dto.MovieDirectorsUpdateRequestDto;
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

    public void updateMovieDetailsByMovieId(Long movieId, MovieDetailsDto dto) {
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

        super.repository.save(movie);
    }

    public void updateMovieDirectors(Long movieId, MovieDirectorsUpdateRequestDto dto) {
        var movie = super.repository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found."));

        var movieDirectors = movie.getDirectors();
        movieDirectors.clear();
        dto.getDirectorIds().forEach(id -> {
            var director = new Director();
            director.setId(id);
            movieDirectors.add(director);
        });
        try {
            repository.save(movie);
        } catch (Exception e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
