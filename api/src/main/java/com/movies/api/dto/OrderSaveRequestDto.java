package com.movies.api.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderSaveRequestDto {
    private List<OrderItemDto> purchases;
    private List<OrderItemDto> rents;
}
