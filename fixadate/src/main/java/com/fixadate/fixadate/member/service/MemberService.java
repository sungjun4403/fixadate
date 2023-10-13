package com.fixadate.fixadate.member.service;


import com.fixadate.fixadate.jwt.filter.JwtRequestFilter;
import com.fixadate.fixadate.jwt.service.JwtService;
import com.fixadate.fixadate.member.dto.MemberCreate;
import com.fixadate.fixadate.member.dto.MemberEdit;
import com.fixadate.fixadate.member.dto.MemberEditor;
import com.fixadate.fixadate.member.dto.MemberResponse;
import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.member.repository.MemberRepository;
import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    @Value("${randNick.adjs}")
    private List<String> RandNickAdjs;
    @Value("${randNick.nouns}")
    private List<String> RandNickNouns;

    private final MemberRepository memberRepository;
    private final JwtRequestFilter jwtRequestFilter;
    private final JwtService jwtService;

    //CREATE MEMBER
    public void create(MemberCreate memberCreate) {

        Member member = Member.builder()
                .name(memberCreate.getName())
                .oauthId(memberCreate.getOauthId())
                .oauthPlatform(memberCreate.getOauthPlatform())
                .nickname(memberCreate.getNickname())
                .birth(memberCreate.getBirth())
                .gender(memberCreate.getGender())
                .profession(memberCreate.getProfession())
                .profileImg(memberCreate.getProfileImg())
                .signatureColor(memberCreate.getSignatureColor())
                .refreshToken(memberCreate.getRefreshToken())
                .build();

        memberRepository.save(member);
    }

    //EDIT MEMBER
    public void edit(MemberEdit memberEdit, Long id) {
        Member member = memberRepository.findById(id).orElseThrow();

        MemberEditor.MemberEditorBuilder memberEditorBuilder = member.toEditor();

        if (memberEdit.getName() != null) {
            memberEditorBuilder.name(memberEdit.getName());
        }
        if (memberEdit.getNickname() != null) {
            memberEditorBuilder.nickname(memberEdit.getNickname());
        }
        if (memberEdit.getBirth() != null) {
            memberEditorBuilder.birth(memberEdit.getBirth());
        }
        if (memberEdit.getGender() != null) {
            memberEditorBuilder.gender(memberEdit.getGender());
        }
        if (memberEdit.getProfession() != null) {
            memberEditorBuilder.profession(memberEdit.getProfession());
        }
        if (memberEdit.getSignatureColor() != null) {
            memberEditorBuilder.signatureColor(memberEdit.getSignatureColor());
        }

        member.edit(memberEditorBuilder.build());

    }

    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public MemberResponse get(String oauthId) {
        Member member = memberRepository.findByOauthId(oauthId).orElseThrow();
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .oauthId(member.getOauthId())
                .oauthPlatform(member.getOauthPlatform())
                .nickname(member.getNickname())
                .birth(member.getBirth())
                .gender(member.getGender())
                .profession(member.getProfession())
                .signatureColor(member.getSignatureColor())
                .build();
    }


    public String getRandNick() {
        Integer randint1 = (int) ((Math.random()) * 19 + 1);
        Integer randint2 = (int) ((Math.random()) * 19 + 1);

        return RandNickAdjs.get(randint1).toString() + " " + RandNickNouns.get(randint2).toString();
    }

    public MemberResponse getByAccessToken(String accessToken, String oauthPlatform) {
        String oauthId = jwtService.extractOauthId(accessToken, oauthPlatform).orElseThrow();
        Member member = memberRepository.findByOauthId(oauthId).orElseThrow();
        MemberResponse memberResponse = MemberResponse.builder().build();

        return memberResponse;

    }
}
