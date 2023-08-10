package com.fixadate.fixadate.memberTeam.controller;


import com.fixadate.fixadate.memberTeam.service.MemberTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberTeamController {
    private final MemberTeamService memberTeamService;

    @PostMapping("/jointeam/{memberId}/{teamId}")
    public void create(@PathVariable Long memberId, @PathVariable Long teamId) {
        memberTeamService.create(memberId, teamId);
    }

    @GetMapping("/group/{memberId}")
    public void 
}
