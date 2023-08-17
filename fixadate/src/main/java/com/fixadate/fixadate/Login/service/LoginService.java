package com.fixadate.fixadate.Login.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
