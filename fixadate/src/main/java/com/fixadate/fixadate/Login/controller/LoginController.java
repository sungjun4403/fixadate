package com.fixadate.fixadate.Login.controller;

import com.fixadate.fixadate.Login.dto.google.GoogleInfResponse;
import com.fixadate.fixadate.Login.dto.google.GoogleResponse;
import com.fixadate.fixadate.Login.dto.kakao.KakaoInfoResponse;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenResponse;
import com.fixadate.fixadate.Login.dto.naver.NaverInfoResponse;
import com.fixadate.fixadate.Login.dto.naver.NaverTokenResponse;
import com.fixadate.fixadate.Login.service.LoginService;
import com.fixadate.fixadate.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class LoginController {
    private final LoginService loginService;
    private final MemberService memberService;
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

    // login procedure { oauth login -> get code -> get token -> get info -> ifuserexists -> (create) -> put token on header }
    // info required for sign up -
    //  name, refreshToken, oauthId, oauthPlatform, profileImg, nickname, birth, gender, profession, signatureColor
    //  이성준, cddkhwjkej212, 212312, Naver, https://s3bucket/,  비싼 크롸쌍, 040521, true, univ student, rgba(0, 0, 0, 0)
    //  editable data (user): profileImg, nickname, profession, signatureColor
    //  editable data (server): refreshToken
    //  static data:  name, gender, birth, oauthId, oauthPlatform, birth


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
        System.out.println(googleInfoResponse);
        System.out.println(googleTokenResponse);
        // send name, refreshToken, oauthId, oauthPlatform, profileImg, nickname, birth, gender, profession, signatureColor
        // fill blank
        // sign in at "/member" "POST"
        return "";
    }

    @GetMapping("/api/naver/login")
    public String afterLoginNaver(@RequestParam(value = "code") String authCode) {
        NaverTokenResponse naverTokenResponse = loginService.naverIssueTokens(authCode);

        NaverInfoResponse naverInfoResponse = loginService.naverGetUserInfo(naverTokenResponse);

        System.out.println(naverInfoResponse.getResponse());

        return "";
    }

    @GetMapping("/api/kakao/login")
    public KakaoInfoResponse afterLoginKakao(@RequestParam(value = "code") String authCode) {
        KakaoTokenResponse kakaoTokenResponse = loginService.kakaoIssueTokens(authCode);

        return loginService.kakaoGetUserInfo(kakaoTokenResponse);
    }

    // ==============logout methods==============
    @GetMapping("/sslogout")
    public void logout(HttpServletRequest request) {
        loginService.logout(request);
    }
}

