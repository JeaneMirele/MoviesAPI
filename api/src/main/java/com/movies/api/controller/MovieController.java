package com.movies.api.controller;

import com.movies.api.domain.Movie;
import com.movies.api.domain.MovieDetails;
import com.movies.api.dto.*;
import com.movies.api.mapper.MovieDetailsMapper;
import com.movies.api.mapper.MovieMapper;
import com.movies.api.services.MovieDetailsService;
import com.movies.api.services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final MovieDetailsMapper movieDetailsMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper, MovieDetailsMapper movieDetailsMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.movieDetailsMapper = movieDetailsMapper;
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponseDto>> getAll(Pageable pageable) {
        var result = movieService.listAll(pageable)
        .map(movie -> {
            var dto = movieMapper.toResponseDto(movie);
            dto.loadLinks(movie);
            return dto;
        });
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieResponseDto> getById(@PathVariable Long id) {
        Movie movie = movieService.listById(id);
        var result = movieMapper.toResponseDto(movie);
        result.loadLinks(movie);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> save(@Valid @RequestBody MovieSaveRequestDto dto) {
        movieService.create(movieMapper.toMovie(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody MovieUpdateRequestDto dto) {
        movieService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/details")
    public ResponseEntity<MovieDetailsDto> getMovieDetailsByMovieId(@PathVariable Long id) {
        MovieDetails movieDetails = movieService.listById(id).getMovieDetails();
        var result = movieDetailsMapper.toMovieDetailsDto(movieDetails);
        result.loadLinks(movieDetails);
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}/details")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateMovieDetails(@PathVariable Long id, @RequestBody MovieDetailsDto dto) {
        this.movieService.updateMovieDetailsByMovieId(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/directors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateDirectors(@PathVariable Long id, @RequestBody MovieDirectorsUpdateRequestDto dto) {
        movieService.updateMovieDirectors(id, dto);
        return ResponseEntity.noContent().build();
    }
}
