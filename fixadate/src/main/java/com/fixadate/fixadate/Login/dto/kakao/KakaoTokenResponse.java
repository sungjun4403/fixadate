package com.fixadate.fixadate.Login.dto.kakao;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KakaoTokenResponse {
    private String token_type;
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String refresh_token_expires_in;

}
