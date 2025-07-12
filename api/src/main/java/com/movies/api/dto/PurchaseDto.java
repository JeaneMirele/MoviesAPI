package com.movies.api.dto;

import com.movies.api.domain.Movie;
import com.movies.api.domain.enums.PurchaseStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PurchaseDto {
    private PurchaseStatus status;
    private MovieResponseDto movie;
    private Double price;
}
