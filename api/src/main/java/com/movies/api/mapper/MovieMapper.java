package com.movies.api.mapper;

import com.movies.api.domain.Movie;
import com.movies.api.dto.MovieResponseDto;
import com.movies.api.dto.MovieSaveRequestDto;
import com.movies.api.dto.MovieUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MovieDetailsMapper.class, DirectorMapper.class})
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    @Mapping(target = "directors", source = "directors")
    MovieResponseDto toResponseDto(Movie movie);

    Movie toMovie(MovieSaveRequestDto movieSaveRequestDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "synopsis", source = "synopsis")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "ageRating", source = "ageRating")
    Movie fromMovieUpdateRequestDto(MovieUpdateRequestDto movieUpdateRequestDto);
}
