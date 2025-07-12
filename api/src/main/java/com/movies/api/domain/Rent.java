package com.movies.api.domain;

import java.time.LocalDateTime;

import com.movies.api.domain.enums.RentStatus;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_rent")
@DiscriminatorValue("Rent")
@PrimaryKeyJoinColumn(name = "order_item_id") 
@AllArgsConstructor
@Data
public class Rent extends OrderItem{
    @Enumerated(EnumType.STRING)
    private RentStatus status;

    private LocalDateTime expirationDate;

    public Rent() {
        super();
        status = RentStatus.PENDING;
    }
}
