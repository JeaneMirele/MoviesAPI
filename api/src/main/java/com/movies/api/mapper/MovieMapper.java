package com.movies.api.mapper;

import com.movies.api.domain.Movie;
import com.movies.api.dto.MovieResponseDto;
import com.movies.api.dto.MovieSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MovieDetailsMapper.class, DirectorMapper.class})
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    MovieResponseDto toResponseDto(Movie movie);

    Movie toMovie(MovieSaveRequestDto movieSaveRequestDto);
}
