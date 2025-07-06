package com.movies.api.mapper;

import com.movies.api.domain.MovieDetails;
import com.movies.api.dto.MovieDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AwardMapper.class})
public interface MovieDetailsMapper {
    MovieDetailsMapper INSTANCE = Mappers.getMapper(MovieDetailsMapper.class);

    MovieDetailsDto toMovieDetailsDto(MovieDetails movieDetails);
    MovieDetails toMovieDetails(MovieDetails movieDetails);

}
