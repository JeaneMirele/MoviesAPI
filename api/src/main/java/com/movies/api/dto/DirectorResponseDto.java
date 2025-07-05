package com.movies.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DirectorResponseDto {
    private Long id;
    private String name;
}
