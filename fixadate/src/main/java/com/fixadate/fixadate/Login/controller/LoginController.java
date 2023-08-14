package com.fixadate.fixadate.Login.controller;

import com.fixadate.fixadate.Login.dto.*;
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
    @Value("${google.client.id}")
    private String googleClientId;
    @Value("${google.client.pw}")
    private String googleClientPw;
    @Value("${naver.client.id}")
    private String naverClientId;
    @Value("${naver.client.pw}")
    private String naverClientPw;

    private final String googleRedirectUri = "http://localhost:3000/googleafterlogin";
    private final String naverRedirectUrl = "http://localhost:3000/naverafterlogin";
    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value="/api/v1/oauth2/google", method = RequestMethod.POST)
    public String afterLoginUrlGoogle(){
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
}
