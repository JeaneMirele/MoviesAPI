package com.movies.api.mapper;

import com.movies.api.domain.Award;
import com.movies.api.dto.AwardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AwardMapper {
    AwardDto toDto(Award award);
    Award toEntity(AwardDto awardDto);
}
