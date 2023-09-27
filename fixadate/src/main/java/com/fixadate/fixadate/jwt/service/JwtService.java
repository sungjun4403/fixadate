package com.fixadate.fixadate.jwt.service;

import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.member.repository.MemberRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


import org.springframework.stereotype.Service;

//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class JwtService {

//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.access.expiration}")
//    private long accessTokenValidityInSeconds;
//
//    @Value("${jwt.refresh.expiration}")
//    private long refreshTokenValidityInSeconds;

    @Value("${jwt.access.header}")
    private String accessHeader;

    @Value("${jwt.refresh.header}")
    private String refreshHeader;

    private static final String ACCESS_TOKEN_SUBJECT = "AccessToken";
    private static final String REFRESH_TOKEN_SUBJECT = "RefreshToken";
    private static final String ID = "UserCode";
    private static final String BEARER = "Bearer ";


    private final MemberRepository memberRepository;

    public String createAccessToken(Member member) {return "";}

    //Custom
    public String getAccessToken(Member member) {
        switch (member.getOauthPlatform()) {
            case "google":

            case "naver":
                System.out.println("naver~");
            case "kakao":
                System.out.println("akakako~");
            case "apple":
                System.out.println("naver~");

        }

        return "";
    }

    //Custom
    public String getRefreshToken() {
        return "";
    }

    //Custom
    public void updateRefreshToken(String oauthId, String refreshToken, String oauthPlatform) {
//        memberRepository.findByGitID(gitID)
//                .ifPresentOrElse(
//                        member -> member.updateRefreshToken(refreshToken),
//                        () -> new Exception("회원이 없습니다")
//                );
    }

    //Custom
    public void sendAccessAndRefreshToken(HttpServletResponse response, String accessToken, String refreshToken, String oauthId) {
        response.setStatus(HttpServletResponse.SC_OK);

        setAccessTokenHeader(response, accessToken);
        setRefreshTokenHeader(response, refreshToken);

        Optional<Member> member = memberRepository.findByOauthId(oauthId);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put(ACCESS_TOKEN_SUBJECT, accessToken);
        tokenMap.put(REFRESH_TOKEN_SUBJECT, refreshToken);
    }

    //Custom
    public void sendAccessToken(HttpServletResponse response, String accessToken) {
        response.setStatus(HttpServletResponse.SC_OK);

        setAccessTokenHeader(response, accessToken);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put(ACCESS_TOKEN_SUBJECT, accessToken);
    }

    //Custom
    public Optional<String> extractAccessToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(accessHeader)).filter(
                accessToken -> accessToken.startsWith(BEARER)
        ).map(accessToken -> accessToken.replace(BEARER, ""));
    }

    //Custom
    public Optional<String> extractRefreshToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(refreshHeader)).filter(
                refreshToken -> refreshToken.startsWith(BEARER)
        ).map(refreshToken -> refreshToken.replace(BEARER, ""));
    }

    //Custom
    public Optional<String> extractOauthId(String accessToken) {
//        try {
//            return Optional.ofNullable(JWT.require(Algorithm.HMAC512(secret)).build().verify(accessToken).getClaim(GITID).asString());
//        }
//        catch (Exception e) {
//            log.error(e.getMessage());
//            return Optional.empty();
//        }
        return "".describeConstable();
    }

    public void setAccessTokenHeader(HttpServletResponse response, String accessToken) {
        response.setHeader(accessHeader, accessToken);
    }

    public void setRefreshTokenHeader(HttpServletResponse response, String refreshToken) {
        response.setHeader(refreshHeader, refreshToken);
    }

    //Custom
    public boolean isTokenValid(String token) {
//        try {
//            JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }
}

