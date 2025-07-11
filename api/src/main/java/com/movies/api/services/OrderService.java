package com.movies.api.services;

import com.movies.api.domain.Order;
import com.movies.api.domain.enums.PurchaseStatus;
import com.movies.api.domain.enums.RentStatus;
import com.movies.api.exceptions.OrderWithoutOrderItemsException;
import com.movies.api.repositorys.OrderRepository;
import com.movies.api.services.generic.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class OrderService extends AbstractService<Order, Long, OrderRepository> {
    private final MovieService movieService;
    public OrderService(OrderRepository repository, MovieService movieService) {
        super(repository);
        this.movieService = movieService;
    }

    public Order listById(Long id, Long userId) {
        var order = super.listById(id);
        if (!order.getClient().getId().equals(userId))
            throw new AccessDeniedException("You don't have permission to get this order");
        return order;
    }

    @Override
    public Order create(Order order) {
        if ((order.getPurchases() == null || order.getPurchases().isEmpty()) &&
            (order.getRents() == null || order.getRents().isEmpty())) {
            throw new OrderWithoutOrderItemsException("Order must have at least one purchase or rent");
        }

        order.getPurchases().forEach(p -> {
            var movieId = p.getMovie().getId();
            p.setMovie(this.movieService.listById(movieId));
            p.setPrice(p.getMovie().getPrice());
            p.setOrder(order);
        });

        order.getRents().forEach(r -> {
            var movieId = r.getMovie().getId();
            r.setMovie(this.movieService.listById(movieId));
            r.setPrice(10.0);
            r.setOrder(order);
        });

        return super.create(order);
    }

    public void pay(Long id, Long userId) {
        Order order = super.listById(id);
        if (!order.getClient().getId().equals(userId)) {
            throw new AccessDeniedException("You don't have permission to pay this order");
        }

        order.getPurchases().forEach(p -> {
            p.setStatus(PurchaseStatus.ACTIVE);
        });

        order.getRents().forEach(r -> {
            r.setStatus(RentStatus.ACTIVE);
            r.setExpirationDate(LocalDateTime.now().plusDays(30));
        });

        repository.save(order);
    }

    public Page<Order> findAllByClientId(Long clientId, Pageable pageable){
        return repository.findAllByClientId(clientId, pageable);
    }

}
