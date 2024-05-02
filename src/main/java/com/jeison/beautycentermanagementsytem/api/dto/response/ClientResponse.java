package com.jeison.beautycentermanagementsytem.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private List<AppointmentResponse> appointment;

}
