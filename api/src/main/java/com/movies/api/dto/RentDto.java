package com.movies.api.dto;

import com.movies.api.domain.Movie;
import com.movies.api.domain.enums.RentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RentDto {
    private RentStatus status;
    private MovieResponseDto movie;
    private Double price;
    private LocalDateTime expirationDate;
}
