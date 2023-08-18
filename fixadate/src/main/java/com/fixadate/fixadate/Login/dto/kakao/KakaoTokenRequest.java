package com.fixadate.fixadate.Login.dto.kakao;

import lombok.*;

@Data
@Builder
public class KakaoTokenRequest {
    private String grantType;
    private String clientId;
    private String redirectUri;
    private String code;
}
