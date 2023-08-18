package com.fixadate.fixadate.Login.service;


import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenRequest;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginService {
    @Value("${kakao.client.id}")
    private String kakaoClientId;
    @Value("${kakao.client.redirect_uri}")
    private String kakaoRedirectUri;

    public String loginUrlKakao() {
        return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + kakaoClientId + "&redirect_uri=" + kakaoRedirectUri;
    }

    public String kakaoIssueTokens(String authCode) {
        RestTemplate restTemplate = new RestTemplate();
        KakaoTokenRequest kakaoTokenRequestParam = KakaoTokenRequest
                .builder()
                .grantType("authorization_code")
                .clientId(kakaoClientId)
                .redirectUri(kakaoRedirectUri)
                .code(authCode)
                .build();

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(kakaoTokenRequestParam); //dto to MultiValueMap

        ResponseEntity<KakaoTokenResponse> kakaoTokenResponse = restTemplate.postForEntity(
                "https://kauth.kakao.com/oauth/token", httpEntity, KakaoTokenResponse.class);

        System.out.println(kakaoTokenResponse.getBody());
        return "";
    }
}
