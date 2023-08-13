package com.fixadate.fixadate.Login.controller;

import com.fixadate.fixadate.Login.dto.GoogleInfResponse;
import com.fixadate.fixadate.Login.dto.GoogleRequest;
import com.fixadate.fixadate.Login.dto.GoogleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class LoginController {
    @Value("${google.client.id}")
    private String googleClientId;
    @Value("${google.client.pw}")
    private String googleClientPw;
    @Value("${naver.client.id}")
    private String naverClientId;
    @Value("${naver.client.pw}")
    private String getNaverClientPw;

    private final String googleRedirectUri = "http://localhost:3000/googleafterlogin";
    private final String naverRedirectUrl = "http://localhost:3000/naverafterlogin";


    @RequestMapping(value="/api/v1/oauth2/google", method = RequestMethod.POST)
    public String loginUrlGoogle(){
        String reqUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + googleClientId
                + "&redirect_uri=" + googleRedirectUri + "&response_type=code&scope=email%20profile%20openid&access_type=offline";
        return reqUrl;
    }
    @RequestMapping(value="/api/v1/oauth2/google", method = RequestMethod.GET)
    public String loginGoogle(@RequestParam(value = "code") String authCode){
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

    @GetMapping("/getnaverloginurl")
    public String loginUrlNaver() {
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${clientId}&redirect_uri=${redirectUri}
        String url = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=" + naverClientId + "&redirect_uri=" + naverRedirectUrl;
        return url;
    }
}
