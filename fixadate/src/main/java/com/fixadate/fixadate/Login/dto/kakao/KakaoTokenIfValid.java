package com.fixadate.fixadate.Login.dto.kakao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KakaoTokenIfValid {
    private String id;
    private String expires_in;
    private String app_id;
}
