package com.movies.api.controller;

import com.movies.api.dto.MovieResponseDto;
import com.movies.api.dto.MovieSaveRequestDto;
import com.movies.api.dto.MovieUpdateRequestDto;
import com.movies.api.mapper.MovieMapper;
import com.movies.api.services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponseDto>> getAll(Pageable pageable) {
        var result = movieService.listAll(pageable).map(movieMapper::toResponseDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieResponseDto> getById(@PathVariable Long id) {
        var result = movieService.listById(id);
        return ResponseEntity.ok(movieMapper.toResponseDto(result));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody MovieSaveRequestDto dto) {
        movieService.create(movieMapper.toMovie(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody MovieUpdateRequestDto dto) {
        movieService.update(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
