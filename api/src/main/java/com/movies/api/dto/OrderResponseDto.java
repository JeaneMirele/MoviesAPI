package com.movies.api.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private List<PurchaseDto> purchases;
    private List<RentDto> rents;
    private LocalDate date;
}
