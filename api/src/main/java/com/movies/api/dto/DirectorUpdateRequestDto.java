package com.movies.api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DirectorUpdateRequestDto {
    private Long id;
    private String name;
}
