package com.jeison.beautycentermanagementsytem.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequest {

    @NotBlank(message = "Name required")
    private String name;
    @NotBlank(message = "Lastname required")
    private String lastName;
    @Size(min = 10, max = 20, message = "Not valid phone")
    private String phone;
    @Email(message = "Not valid email")
    @Size(min = 5,max = 100, message = "Email length not valid")
    private String email;
    

}
