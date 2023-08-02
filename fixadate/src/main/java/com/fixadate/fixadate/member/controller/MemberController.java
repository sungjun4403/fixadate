package com.fixadate.fixadate.member.controller;

import com.fixadate.fixadate.member.dto.MemberCreate;
import com.fixadate.fixadate.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/hello")
    public String hello() {
        return "HELLLLLLLLO";
    }

    @PostMapping("/member")
    public void create (@RequestBody MemberCreate memberCreate) {
        memberService.create(memberCreate);
    }
}
