package com.jeison.beautycentermanagementsytem.api.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {

    private Long id;
    private LocalDate date;
    private int durarion;
    private String comments;
    
}
