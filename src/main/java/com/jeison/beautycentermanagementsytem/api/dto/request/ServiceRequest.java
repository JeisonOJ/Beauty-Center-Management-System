package com.jeison.beautycentermanagementsytem.api.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequest {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
