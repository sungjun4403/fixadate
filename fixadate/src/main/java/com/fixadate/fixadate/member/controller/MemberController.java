package com.fixadate.fixadate.member.controller;

import com.fixadate.fixadate.member.dto.MemberCreate;
import com.fixadate.fixadate.member.dto.MemberEdit;
import com.fixadate.fixadate.member.dto.MemberResponse;
import com.fixadate.fixadate.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    //VIEW ONE
    @GetMapping("/member/{memberId}")
    public MemberResponse get(@PathVariable Long memberId) {
        return memberService.get(memberId);
    }

    //CREATE
    @PostMapping("/member")
    public void create (@RequestBody MemberCreate memberCreate) {
        memberService.create(memberCreate);
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
