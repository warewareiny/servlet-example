package org.example.carrentalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String passportNumber;
    private LocalDateTime createdAt;
}
