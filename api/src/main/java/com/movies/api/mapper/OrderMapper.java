package com.movies.api.mapper;

import com.movies.api.domain.Order;
import com.movies.api.domain.Purchase;
import com.movies.api.domain.Rent;
import com.movies.api.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order toEntity(OrderSaveRequestDto orderSaveRequestDto);

    @Mapping(target = "movie.id", source = "movieId")
    Purchase toPurchase(OrderItemDto purchaseDto);
    @Mapping(target = "movie.id", source = "movieId")
    Rent toRent(OrderItemDto rentDto);

    @Mapping(target = "status", source = "status")
    PurchaseDto toDto(Purchase purchase);
    @Mapping(target = "status", source = "status")
    RentDto toDto(Rent rent);

    OrderResponseDto toDto(Order order);
}
