package com.movies.api.mapper;

import com.movies.api.domain.SecurityUser;
import com.movies.api.dto.ClientSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SecurityUserMapper {
    SecurityUserMapper INSTANCE = Mappers.getMapper(SecurityUserMapper.class);
    @Mapping(target = "client.name", source = "name")
    @Mapping(target = "client.isAdmin", source = "isAdmin")
    @Mapping(target = "client.birthday", source = "birthday")
    SecurityUser toEntity(ClientSaveRequestDto clientSaveRequestDto);
}
