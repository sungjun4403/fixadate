package com.fixadate.fixadate.Login.service;

import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenIfValid;
import com.fixadate.fixadate.Login.dto.naver.NaverTokenIfValid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    public KakaoTokenIfValid KakaoTokenIfValid(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+ accessToken);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<KakaoTokenIfValid> kakaoTokenIfValid = restTemplate.exchange("https://kapi.kakao.com/v1/user/access_token_info", HttpMethod.GET, httpEntity, KakaoTokenIfValid.class);
        return kakaoTokenIfValid.getBody();
    }

    //    public GoogleTokenIfValid
    public NaverTokenIfValid NaverTokenIfValid(String accessToken) {
        //mothafuxking naver does not provide independent token validation api. Thereby, NaverTokenResponse collects partial data from user profile view
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+ accessToken);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<NaverTokenIfValid> naverTokenIfValid = restTemplate.exchange("https://kapi.kakao.com/v1/user/access_token_info", HttpMethod.GET, httpEntity, NaverTokenIfValid.class);
        return naverTokenIfValid.getBody();
    }
}
