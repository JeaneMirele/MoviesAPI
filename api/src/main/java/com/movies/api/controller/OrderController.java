package com.movies.api.controller;

import com.movies.api.domain.SecurityUser;
import com.movies.api.dto.OrderSaveRequestDto;
import com.movies.api.mapper.OrderMapper;
import com.movies.api.services.OrderService;
import com.movies.api.services.SecurityUserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final SecurityUserService securityUserService;
    private final OrderMapper orderMapper;

    public OrderController(
            OrderService orderService,
            SecurityUserService securityUserService,
            OrderMapper orderMapper) {
        this.orderService = orderService;
        this.securityUserService = securityUserService;
        this.orderMapper = orderMapper;
    }

    private SecurityUser getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return securityUserService.findByUsername(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable) {
        var result = orderService.findAllByClientId(getLoggedUser().getClient().getId(), pageable);

        return ResponseEntity.ok(result.map(orderMapper::toDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var result = orderService.listById(id, getLoggedUser().getClient().getId());
        return ResponseEntity.ok(orderMapper.toDto(result));
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody OrderSaveRequestDto dto) {
        var order = orderMapper.toEntity(dto);
        order.setClient(getLoggedUser().getClient());
        orderService.create(order);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/payment")
    public ResponseEntity<?> payment (@PathVariable Long id) {
        orderService.pay(id, getLoggedUser().getClient().getId());
        return ResponseEntity.noContent().build();
    }
    /*
    OrderController
      GET /orders?page={page}&size={size}
      - Response: Listagem paginada de pedidos (com Purchases e Rents)
      - Acesso: Propriedade do Cliente

      GET /orders/{id}
      - Response: Order (com Purchases e Rents)
      - Acesso: Propriedade do Cliente

      POST /orders
      - Request: Order (com Purchases e Rents, sem preços)
      - Response: Valor total do pedido
      - Acesso: Propriedade do Cliente

      POST /orders/{id}/payment/
      - Ação: confirma pagamento, alterando o status do pedido
      - Acesso: Propriedade do Cliente

      DELETE /orders/{id}
      - Ação: cancela pedido se não for "pago"
      - Acesso: Propriedade do Cliente
     */
}
