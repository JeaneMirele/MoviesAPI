package com.movies.api.repositorys;

import com.movies.api.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAllByClientId(Long clientId, Pageable pageable);
}
