package com.jeison.beautycentermanagementsytem.api.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequest {

    @NotBlank(message = "Name required")
    private String name;
    private String description;
    @DecimalMin(value = "0.01", message = "Price must be over zero")
    private BigDecimal price;
}
