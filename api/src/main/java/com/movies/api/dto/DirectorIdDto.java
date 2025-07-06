package com.movies.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class DirectorIdDto {
    private Long id;
}
