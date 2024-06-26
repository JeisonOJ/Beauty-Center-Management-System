package com.jeison.beautycentermanagementsytem.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponse {

    private Long id;
    private LocalDateTime date;
    private Integer durarion;
    private String comments;
    private ServiceResponse serviceResponse;
    private EmployeeResponse employeeResponse;
    private SimpleClientResp simpleClientResp;
    
}
