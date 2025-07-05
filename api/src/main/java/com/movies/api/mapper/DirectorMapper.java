package com.movies.api.mapper;

import com.movies.api.domain.Director;
import com.movies.api.dto.DirectorIdDto;
import com.movies.api.dto.DirectorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    @Mapping(target = "id", source = "id")
    Director toDirectorIdDto(DirectorIdDto directorIdDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DirectorResponseDto toDirectorResponseDto(Director director);

}
