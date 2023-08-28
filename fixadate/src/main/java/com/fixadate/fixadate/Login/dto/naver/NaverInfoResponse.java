package com.fixadate.fixadate.Login.dto.naver;

import com.fixadate.fixadate.Login.dto.naver.NaverInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NaverInfoResponse {
    private String resultcode;
    private String message;
    private NaverInfo response;

}
