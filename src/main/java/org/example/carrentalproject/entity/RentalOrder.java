package org.example.carrentalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalOrder {

    private Long id;
    private Long rentalRequestId;
    private Long clientId;
    private Long carId;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;
}
