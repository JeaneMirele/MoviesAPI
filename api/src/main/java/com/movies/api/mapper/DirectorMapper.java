package com.movies.api.mapper;

import com.movies.api.domain.Director;
import com.movies.api.domain.Movie;
import com.movies.api.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    Director toDirectorIdDto(DirectorIdDto directorIdDto);

    DirectorResponseDto toDirectorResponseDto(Director director);

    @Mapping(target = "movieTitles", source = "movies")
    DirectorWithMovieNamesDto toDirectorWithMovieNames(Director director);

    Director toEntity(DirectorSaveRequestDto directorSaveRequestDto);
    Director toEntity(DirectorUpdateRequestDto directorUpdateRequestDto);
    default String map(Movie movie) {
        if (movie == null) {
            return null;
        }
        return movie.getTitle();
    }
}
