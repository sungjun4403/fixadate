package com.fixadate.fixadate.Login.service;


import com.fixadate.fixadate.Login.dto.NaverTokenResponse;
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

import javax.swing.text.html.parser.Entity;

@Service
@Transactional
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginService {
    @Value("${google.client.id}")
    private String googleClientId;
    @Value("${google.client.pw}")
    private String googleClientPw;
    @Value("${naver.client.id}")
    private String naverClientId;
    @Value("${naver.client.pw}")
    private String naverClientPw;
    @Value("${google.client.redirect_uri}")
    private String googleRedirectUri;
    @Value("${naver.client.redirect_uri}")
    private String naverRedirectUrl;
    @Value("${kakao.client.id}")
    private String kakaoClientId;
    @Value("${kakao.client.redirect_uri}")
    private String kakaoRedirectUri;


    // ==============getloginurl methods==============
    public String loginUrlGoogle() {
        return "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + googleClientId
                + "&redirect_uri=" + googleRedirectUri
                + "&response_type=code&scope=email%20profile%20openid&access_type=offline";
    }

    public String loginUrlNaver() {
        return "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=" + naverClientId
                + "&redirect_uri=" + naverRedirectUrl;
    }

    public String loginUrlKakao() {
        return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + kakaoClientId
                + "&redirect_uri=" + kakaoRedirectUri;
    }

    public String loginUrlApple() {


        return "";
    }


    // ==============get tokens methods==============
    public String kakaoIssueTokens(String authCode) {
        RestTemplate restTemplate = new RestTemplate();
        KakaoTokenRequest kakaoTokenRequestParam = KakaoTokenRequest
                .builder()
                .grantType("authorization_code")
                .clientId(kakaoClientId)
                .redirectUri(kakaoRedirectUri)
                .code(authCode)
                .build();

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", kakaoClientId);
        body.add("redirect_uri", kakaoRedirectUri);
        body.add("code", authCode);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, headers); //dto to MultiValueMap

        ResponseEntity<KakaoTokenResponse> kakaoTokenResponse = restTemplate.postForEntity(
                "https://kauth.kakao.com/oauth/token", httpEntity, KakaoTokenResponse.class);

        System.out.println(kakaoTokenResponse.getBody());
        return "";
    }

    public NaverTokenResponse getNaverTokens(String authCode) {
        String url = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=" + naverClientId + "&client_secret=" + naverClientPw + "&code=" + authCode;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NaverTokenResponse> naverTokenResponse = restTemplate.getForEntity(url, NaverTokenResponse.class);
        System.out.println(naverTokenResponse);
        return naverTokenResponse.getBody();
    }

}
