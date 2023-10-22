package com.fixadate.fixadate.Login.dto.naver;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NaverTokenIfValid {
    private String resultcode;
    private String message;
    private NaverRestirctedInfo response;
}
