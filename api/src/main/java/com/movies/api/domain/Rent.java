package com.movies.api.domain;

import java.time.LocalDateTime;

import com.movies.api.domain.enums.RentStatus;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "tb_rent")
@DiscriminatorValue("Rent")
@PrimaryKeyJoinColumn(name = "order_item_id") 
@Builder
public class Rent extends OrderItem{
    @Enumerated(EnumType.STRING)
    private RentStatus status;

    private LocalDateTime expirationDate;


}
