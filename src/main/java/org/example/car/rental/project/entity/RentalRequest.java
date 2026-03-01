package org.example.car.rental.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalRequest {

    private Long rentalRequestId;
    private Long clientId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private RequestStatus status;
    private String rejectionReason;
    private Long processedBy;
    private LocalDateTime createdAt;

}
