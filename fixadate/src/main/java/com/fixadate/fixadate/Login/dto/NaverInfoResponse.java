package com.fixadate.fixadate.Login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class NaverInfoResponse {
    private String resultcode;
    private String message;
    private NaverInfo response;

}
