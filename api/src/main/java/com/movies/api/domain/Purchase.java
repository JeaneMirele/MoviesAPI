package com.movies.api.domain;

import com.movies.api.domain.enums.PurchaseStatus;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "tb_purchase")
@DiscriminatorValue("Purchase")
@PrimaryKeyJoinColumn(name = "order_item_id")
@Builder
public class Purchase extends OrderItem{
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;
}
