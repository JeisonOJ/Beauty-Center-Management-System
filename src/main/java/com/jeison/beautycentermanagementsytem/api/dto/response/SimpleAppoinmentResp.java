package com.jeison.beautycentermanagementsytem.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor  
public class SimpleAppoinmentResp {

    private Long id;
    private LocalDateTime date;
    private int durarion;
    private String comments;
    private ServiceResponse serviceResponse;
    private EmployeeResponse employeeResponse;
}
