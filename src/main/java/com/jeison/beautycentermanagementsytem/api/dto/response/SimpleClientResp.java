package com.jeison.beautycentermanagementsytem.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleClientResp {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
}
