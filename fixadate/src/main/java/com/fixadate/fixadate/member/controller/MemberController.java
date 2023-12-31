package com.fixadate.fixadate.member.controller;

import com.fixadate.fixadate.Login.dto.kakao.KakaoTokenIfValid;
import com.fixadate.fixadate.Login.dto.naver.NaverTokenIfValid;
import com.fixadate.fixadate.Login.service.AuthService;
import com.fixadate.fixadate.global.utils.SecurityUtil;
import com.fixadate.fixadate.jwt.service.JwtService;
import com.fixadate.fixadate.member.dto.MemberCreate;
import com.fixadate.fixadate.member.dto.MemberEdit;
import com.fixadate.fixadate.member.dto.MemberResponse;
import com.fixadate.fixadate.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.*;

// SIGN UP FLOW CHART
// 1. LOGIN WITH OAUTH
// 2. PASS OAUTH INFO (N TOKENS) TO INPUT PAGE
// 3. SIGN IN (CREATE MEMBER)

@RequiredArgsConstructor
@RestController
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final AuthService authService;
    private final JwtService jwtService;

    //VIEW ONE without authorities
    @GetMapping("/member/{oauthId}")
    public MemberResponse get(@PathVariable String oauthId) {
        return memberService.get(oauthId);
    }

    //VIEW ONE with authorities
    @GetMapping("/member/withtoken")
    public MemberResponse get(HttpServletRequest request) {
        String oauthId = jwtService.extractOauthId(jwtService.extractAccessToken(request).orElseThrow(), jwtService.extractOauthPlatform(request)).orElseThrow();
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
//        SecurityContextHolder.clearContext();
        if (SecurityUtil.getLoginedUserOauthId().equals(oauthId)) {
            String accessToken = request.getHeader("Authorization").split(" ")[1];
            String oauthPlatform= request.getHeader("oauthPlEatform");
            return memberService.get(oauthId);
        }
        else {
            throw new IllegalStateException("Encryption failed");
        }

    }

    //CREATE
    @PostMapping("/member")
    public void create (@RequestBody MemberCreate memberCreate, HttpServletRequest request) throws IllegalStateException {
        // check if user token is valid -> if true run function
        // exceptional authentication situation
        // gotta check if token is valid before its owner's member db is pushed
        String accessToken = request.getHeader("Authorization").split(" ")[1];
        String oauthPlatform = request.getHeader("oauthPlatform");
        String oauthIdFromToken = null;

        System.out.println(accessToken);
        System.out.println(oauthPlatform);

        switch (oauthPlatform) {
            case "kakao":
                KakaoTokenIfValid kakaoTokenIfValid = authService.KakaoTokenIfValid(accessToken);
                oauthIdFromToken = kakaoTokenIfValid.getId();
            case "google":
            case "naver":
                NaverTokenIfValid naverTokenIfValid = authService.NaverTokenIfValid(accessToken);
//                oauthIdFromToken = naverTokenIfValid.getResponse().getId();
            case "apple":
        }


        if (memberCreate.getOauthId().equals(oauthIdFromToken)) {
            memberService.create(memberCreate);
        }
        else {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid AccessToken");
            throw illegalStateException;
        }
    }

    //EDIT
    @PatchMapping("/member/{memberId}")
    public void edit (@PathVariable Long memberId, @RequestBody MemberEdit memberEdit) {
        memberService.edit(memberEdit, memberId);
    }

    //DELETE
    @DeleteMapping("/member/{memberId}")
    public void delete (@PathVariable Long memberId) {
        memberService.delete(memberId);
    }

    @GetMapping("/getrandnick")
    public String getRandNick() {
        return memberService.getRandNick();
    }
}

