package com.jeison.beautycentermanagementsytem.api.dto.erros;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseErrorResp implements Serializable{
    private Integer code;
    private String status;
}
