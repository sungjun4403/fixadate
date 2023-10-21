package com.fixadate.fixadate.Login.dto.naver;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NaverTokenResponse {

    private String access_token;
    private String refresh_token;
    private String token_type;
    private String expires_in;
}
