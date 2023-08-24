package com.fixadate.fixadate.Login.controller;

import com.fixadate.fixadate.Login.dto.*;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenRequest;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenResponse;
import com.fixadate.fixadate.Login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class LoginController {
    private final LoginService loginService;
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


    // ==============getloginurl methods==============
    @GetMapping("/getgoogleloginurl")
    public String loginUrlGoogle() {
        return loginService.loginUrlGoogle();
    }

    @GetMapping("/getnaverloginurl")
    public String loginUrlNaver() {
        return loginService.loginUrlNaver();
    }

    @GetMapping("/getkakaologinurl")
    public String loginUrlKakao() {
        return loginService.loginUrlKakao();
    }

    @GetMapping("/getappleloginurl")
    public String loginUrlApple() {
        return loginService.loginUrlApple();
    }


    // ==============afterlogin methods==============
    @GetMapping("/api/v1/oauth2/google")
    public String loginGoogle(@RequestParam(value = "code") String authCode) {
        GoogleResponse googleTokenResponse = loginService.googleIssueTokens(authCode);

        GoogleInfResponse googleInfoResponse = loginService.googleGetUserInfo(googleTokenResponse);

        String email = googleInfoResponse.getEmail();

        return email;
    }

    @GetMapping("/api/naver/login")
    public String afterLoginNaver(@RequestParam(value = "code") String authCode) {
        NaverTokenResponse naverTokenResponse = loginService.naverIssueTokens(authCode);

        NaverInfoResponse naverInfoResponse = loginService.naverGetUserInfo(naverTokenResponse);

        System.out.println(naverInfoResponse.getResponse());

        return "";
    }

    @GetMapping("/api/kakao/login")
    public String afterLoginKakao(@RequestParam(value = "code") String authCode) {
        KakaoTokenResponse kakaoTokenResponse = loginService.kakaoIssueTokens(authCode);
        return "";
    }

}

