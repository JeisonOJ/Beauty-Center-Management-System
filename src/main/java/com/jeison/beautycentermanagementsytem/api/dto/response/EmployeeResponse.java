package com.jeison.beautycentermanagementsytem.api.dto.response;

import com.jeison.beautycentermanagementsytem.utils.enums.RoleEmployee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private RoleEmployee roleEmployee;
    
}
