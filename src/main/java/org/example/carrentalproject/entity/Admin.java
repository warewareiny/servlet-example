package org.example.carrentalproject.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {

    private Long idAdmin;
    private String username;
    private String password;
    private LocalDateTime createdAt;

}
