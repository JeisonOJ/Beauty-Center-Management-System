package com.jeison.beautycentermanagementsytem.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequest {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;

}
