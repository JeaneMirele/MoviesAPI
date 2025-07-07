package com.movies.api.controller;

import com.movies.api.domain.Director;
import com.movies.api.dto.DirectorSaveRequestDto;
import com.movies.api.dto.DirectorUpdateRequestDto;
import com.movies.api.mapper.DirectorMapper;
import com.movies.api.services.DirectorService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;
    private final DirectorMapper directorMapper;

    public DirectorController(DirectorService directorService, DirectorMapper directorMapper) {
        this.directorService = directorService;
        this.directorMapper = directorMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        var result = directorService.listAll(pageable).map(directorMapper::toDirectorResponseDto);
        return ResponseEntity.ok(result);
    }



    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var result = directorMapper.toDirectorWithMovieNames(directorService.listById(id));
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DirectorSaveRequestDto dto) {
        directorService.create(directorMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody DirectorUpdateRequestDto dto) {
        directorService.update(directorMapper.toEntity(dto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        directorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
