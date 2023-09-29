package com.fixadate.fixadate.Login.service;

import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenIfValid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    public Boolean KakaoTokenIfValid(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+ accessToken);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<KakaoTokenIfValid> kakaoTokenIfValid = restTemplate.exchange("https://kapi.kakao.com/v1/user/access_token_info", HttpMethod.GET, httpEntity, KakaoTokenIfValid.class);
        System.out.println(kakaoTokenIfValid);
        System.out.println(kakaoTokenIfValid.getBody());
        return true;
    }
}