package com.fixadate.fixadate.Login.service;


import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenRequest;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {
    @Value("${kakao.client.id}")
    private String kakaoClientId;
    @Value("${kakao.client.redirect_uri}")
    private String kakaoRedirectUri;

    public String loginUrlKakao() {
        return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + kakaoClientId + "&redirect_uri=" + kakaoRedirectUri;
    }
    private final RestTemplate restTemplate = new RestTemplate();

    public String kakaoIssueTokens(String authCode) {
        KakaoTokenRequest kakaoTokenRequest = KakaoTokenRequest.builder()
                .grant_type("authorization_code")
                .client_id(kakaoClientId)
                .redirect_uri(kakaoRedirectUri)
                .code(authCode)
                .build();

        HttpEntity httpEntity = new HttpEntity();
        ResponseEntity<KakaoTokenResponse> kakaoTokenResponse = restTemplate.postForEntity(
                "https://kauth.kakao.com/oauth/token",
                kakaoTokenRequest,
                KakaoTokenResponse.class
        )

        return "";
    }
}
