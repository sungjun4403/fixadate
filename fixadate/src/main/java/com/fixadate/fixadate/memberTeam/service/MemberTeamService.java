package com.fixadate.fixadate.memberTeam.service;

import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.member.repository.MemberRepository;
import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import com.fixadate.fixadate.memberTeam.repository.MemberTeamRepository;
import com.fixadate.fixadate.team.entity.Team;
import com.fixadate.fixadate.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberTeamService {
    private final MemberTeamRepository memberTeamRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public void create(Long memberId, Long teamId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Team team = teamRepository.findById(teamId).orElseThrow();

        MemberTeam memberTeam = MemberTeam.builder()
                .member(member)
                .team(team)
                .build();
        memberTeamRepository.save(memberTeam);
    }
}
