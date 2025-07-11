package com.movies.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemDto {
    @NotNull
    private Long movieId;
}
