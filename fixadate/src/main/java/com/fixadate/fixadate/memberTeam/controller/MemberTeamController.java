package com.fixadate.fixadate.memberTeam.controller;


import com.fixadate.fixadate.memberTeam.service.MemberTeamService;
import com.fixadate.fixadate.team.dto.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberTeamController {
    private final MemberTeamService memberTeamService;

    @PostMapping("/jointeam/{memberId}/{teamId}")
    public void create(@PathVariable Long memberId, @PathVariable Long teamId) {
        memberTeamService.create(memberId, teamId);
    }

    @GetMapping("/group/{memberId}")
    public List<TeamResponse> viewAllByMember(@PathVariable Long memberId) {
        return memberTeamService.viewAllByMember(memberId);
    }
}
