package com.jeison.beautycentermanagementsytem.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {

    @NotBlank(message = "Date and time required")
    private LocalDateTime date;
    @Min(value = 10, message = "Duration must be greather than 10")
    @Max(value = 720, message = "Duration must be less than 720")
    private Integer durarion;
    private String comments;
    @NotNull(message = "Client id required")
    private Long clientId;
    @NotNull(message = "Employee id required")
    private Long employeeId;
    @NotNull(message = "Service id required")
    private Long serviceId;
    
}
