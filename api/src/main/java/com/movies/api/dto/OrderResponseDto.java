package com.movies.api.dto;

import com.movies.api.controller.MovieController;
import com.movies.api.controller.OrderController;
import com.movies.api.domain.MovieDetails;
import com.movies.api.domain.Order;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDto extends RepresentationModel<OrderResponseDto> {
    private Long id;
    private List<PurchaseDto> purchases;
    private List<RentDto> rents;
    private LocalDate date;

    public void loadLinks(Order order) {
        this.add(WebMvcLinkBuilder.linkTo(OrderController.class).slash(order.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(OrderController.class).withRel("Order"));
        this.add(WebMvcLinkBuilder.linkTo(OrderController.class).slash(order.getId()).withRel("delete"));
    }
}
