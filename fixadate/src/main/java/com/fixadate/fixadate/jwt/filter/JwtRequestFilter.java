package com.fixadate.fixadate.jwt.filter;

import java.io.IOException;

import com.fixadate.fixadate.jwt.service.JwtService;


import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;
    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
    private String NO_CHECK_URL = "/login";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals(NO_CHECK_URL)) {
            filterChain.doFilter(request, response);
            return;
        }
        String oauthPlatform = getOauthPlatformFromRequest(request);
        System.out.println("oauthPlatform:" + oauthPlatform);
        System.out.println("oauthPlatform:" + oauthPlatform);
        System.out.println("oauthPlatform:" + oauthPlatform);
        String refreshToken = jwtService
                .extractRefreshToken(request)
                .filter(jwtService::isTokenValid)
                .orElse(null);

//        if (refreshToken != null) {
//            checkRefreshTokenAndReIssueAccessToken(response, refreshToken);
//            return;
//        }

        checkAccessTokenAndAuthentication(request, response, filterChain, oauthPlatform);
    }

    public String getOauthPlatformFromRequest(HttpServletRequest request) {
        return request.getHeader("oauthPlatform");
    }

    private void checkAccessTokenAndAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, String oauthPlatform) throws ServletException, IOException {
        jwtService.extractAccessToken(request).ifPresent(
                accessToken -> jwtService.extractOauthId(accessToken, oauthPlatform).ifPresent(
                        oauthId -> {
                            memberRepository.findByOauthId(oauthId).ifPresent(
                                    this::saveAuthentication
                            );
                        }
                )
        );
        filterChain.doFilter(request, response);
    }

    private void saveAuthentication(Member member) {
        UserDetails user = User.builder()
                .username(member.getOauthId())
                .password(member.getRefreshToken())
                .roles("user")
                .build();

        System.out.println("USER");
        System.out.println(user.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authoritiesMapper.mapAuthorities(user.getAuthorities()));
        System.out.println("authentication");
//        System.out.println(authentication);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
    }


}

