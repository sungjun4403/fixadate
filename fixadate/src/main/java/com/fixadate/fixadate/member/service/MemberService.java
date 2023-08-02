package com.fixadate.fixadate.member.service;


import com.fixadate.fixadate.member.dto.MemberCreate;
import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void create(MemberCreate memberCreate) {
        Member member = Member.builder()
                .name(memberCreate.getName())
                .nickname(memberCreate.getNickname())
                .birth(memberCreate.getBirth())
                .gender(memberCreate.getGender())
                .profession(memberCreate.getProfession())
                .signatureColor(memberCreate.getSignatureColor())
                .build();

        memberRepository.save(member);
    }
}
