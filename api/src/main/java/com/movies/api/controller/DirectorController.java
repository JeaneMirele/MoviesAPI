package com.movies.api.controller;

import com.movies.api.domain.Director;
import com.movies.api.dto.DirectorSaveRequestDto;
import com.movies.api.dto.DirectorUpdateRequestDto;
import com.movies.api.mapper.DirectorMapper;
import com.movies.api.services.DirectorService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
         var result = directorService.listAll(pageable)
                 .map(director -> {
                     var dto = directorMapper.toDirectorResponseDto(director);
                     dto.loadLinks(director);
                     return dto;
                 });
         return ResponseEntity.ok(result);
     }


    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Director director = directorService.listById(id);
        var result = directorMapper.toDirectorWithMovieNames(director);
        result.loadLinks(director);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody DirectorSaveRequestDto dto) {
        directorService.create(directorMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody DirectorUpdateRequestDto dto) {
        directorService.update(directorMapper.toEntity(dto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        directorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
