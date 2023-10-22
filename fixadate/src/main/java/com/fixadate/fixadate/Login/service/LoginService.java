package com.fixadate.fixadate.Login.service;


import com.fixadate.fixadate.Login.dto.google.GoogleInfResponse;
import com.fixadate.fixadate.Login.dto.google.GoogleRequest;
import com.fixadate.fixadate.Login.dto.google.GoogleResponse;
import com.fixadate.fixadate.Login.dto.kakao.KakaoInfoResponse;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenRequest;
import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenResponse;
import com.fixadate.fixadate.Login.dto.naver.NaverInfoResponse;
import com.fixadate.fixadate.Login.dto.naver.NaverTokenResponse;
import com.fixadate.fixadate.global.utils.SecurityUtil;
import com.fixadate.fixadate.jwt.service.JwtService;
import com.fixadate.fixadate.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
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

    private final MemberService memberService;
    private final JwtService jwtService;


    RestTemplate restTemplate = new RestTemplate();

    // ============== getloginurl methods ==============
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


    // ============== get tokens methods ==============
    public GoogleResponse googleIssueTokens(String authCode) {
        GoogleRequest googleOAuthRequestParam = GoogleRequest
                .builder()
                .clientId(googleClientId)
                .clientSecret(googleClientPw)
                .code(authCode)
                .redirectUri(googleRedirectUri)
                .grantType("authorization_code").build();
        ResponseEntity<GoogleResponse> resultEntity = restTemplate.postForEntity("https://oauth2.googleapis.com/token",
                googleOAuthRequestParam, GoogleResponse.class);
        return  resultEntity.getBody();
    }

    public NaverTokenResponse naverIssueTokens(String authCode) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=" + naverClientId
                + "&client_secret=" + naverClientPw
                + "&code=" + authCode;

        ResponseEntity<NaverTokenResponse> naverTokenResponse = restTemplate.getForEntity(url, NaverTokenResponse.class);
        return naverTokenResponse.getBody();
    }

    public KakaoTokenResponse kakaoIssueTokens(String authCode) {
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

        return kakaoTokenResponse.getBody();
    }


    // ============== get info methods ==============
    public GoogleInfResponse googleGetUserInfo(GoogleResponse googleTokenResponse) {
        String jwtToken = googleTokenResponse.getId_token();
        Map<String, String> map=new HashMap<>();
        map.put("id_token",jwtToken);
        ResponseEntity<GoogleInfResponse> googleInfoResponse = restTemplate.postForEntity("https://oauth2.googleapis.com/tokeninfo",
                map, GoogleInfResponse.class);

        return googleInfoResponse.getBody();
    }

    public NaverInfoResponse naverGetUserInfo(NaverTokenResponse naverTokenResponse) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + naverTokenResponse.getAccess_token());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NaverInfoResponse> naverInfoResponse = restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.GET,
                entity,
                NaverInfoResponse.class
        );
        naverInfoResponse.getBody().setNaverTokenResponse(naverTokenResponse);
        return naverInfoResponse.getBody();
    }

    public KakaoInfoResponse kakaoGetUserInfo(KakaoTokenResponse kakaoTokenResponse) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+kakaoTokenResponse.getAccess_token());

        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
//        String result = String.valueOf(restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.GET, httpEntity, String.class));
//        System.out.println(result);
        ResponseEntity<KakaoInfoResponse> kakaoInfoResponse = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.GET, httpEntity, KakaoInfoResponse.class);
        kakaoInfoResponse.getBody().setKakaoTokenResponse(kakaoTokenResponse);

        return kakaoInfoResponse.getBody();
    }
    // ============== packing up for memberService ==============

    public void logout(HttpServletRequest request) {
        String oauthId = jwtService.extractOauthId(jwtService.extractAccessToken(request).orElseThrow(), jwtService.extractOauthPlatform(request)).orElseThrow();

        if (SecurityUtil.getLoginedUserOauthId().equals(oauthId)) { //verified
            System.out.println(SecurityContextHolder.getContext().getAuthentication()); //before logout
            SecurityContextHolder.clearContext();
            System.out.println(SecurityContextHolder.getContext().getAuthentication()); //after logout
        }
        else { // anonymous user trying to logout
            throw new IllegalStateException("NON USER TRYING TO LOGOUT");
        }

    }
}
