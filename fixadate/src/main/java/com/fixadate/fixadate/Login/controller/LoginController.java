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
        RestTemplate restTemplate = new RestTemplate();
        GoogleRequest googleOAuthRequestParam = GoogleRequest
                .builder()
                .clientId(googleClientId)
                .clientSecret(googleClientPw)
                .code(authCode)
                .redirectUri(googleRedirectUri)
                .grantType("authorization_code").build();
        ResponseEntity<GoogleResponse> resultEntity = restTemplate.postForEntity("https://oauth2.googleapis.com/token",
                googleOAuthRequestParam, GoogleResponse.class);
        String jwtToken=resultEntity.getBody().getId_token();
        Map<String, String> map=new HashMap<>();
        map.put("id_token",jwtToken);
        ResponseEntity<GoogleInfResponse> resultEntity2 = restTemplate.postForEntity("https://oauth2.googleapis.com/tokeninfo",
                map, GoogleInfResponse.class);
        String email=resultEntity2.getBody().getEmail();
        System.out.println(resultEntity2.getBody());

        return email;
    }


//    https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=jyvqXeaVOVmV&client_secret=527300A0_COq1_XV33cf&code=EIc5bFrl4RibFls1&state=9kgsGTfH4j7IyAkg
    @GetMapping("/api/naver/login")
    public String afterLoginNaver(@RequestParam(value = "code") String authCode) {
        String url = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=" + naverClientId + "&client_secret=" + naverClientPw + "&code=" + authCode;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NaverTokenResponse> naverTokenResponse = restTemplate.getForEntity(url, NaverTokenResponse.class);
        System.out.println(naverTokenResponse);

        System.out.println(naverTokenResponse.getBody().getAccess_token());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + naverTokenResponse.getBody().getAccess_token());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NaverInfoResponse> naverInfoResponse = restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.GET,
                entity,
                NaverInfoResponse.class
        );

        System.out.println(naverInfoResponse.getBody().getResponse());
        return "";
    }


    @GetMapping("/api/kakao/login")
    public String afterLoginKakao(@RequestParam(value = "code") String authCode) {
         return loginService.kakaoIssueTokens(authCode);
    }

}

