package com.fixadate.fixadate.member.service;


import com.fixadate.fixadate.member.dto.MemberCreate;
import com.fixadate.fixadate.member.dto.MemberEdit;
import com.fixadate.fixadate.member.dto.MemberEditor;
import com.fixadate.fixadate.member.dto.MemberResponse;
import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.member.repository.MemberRepository;
import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //CREATE MEMBER
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

    public MemberResponse get(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .birth(member.getBirth())
                .gender(member.getGender())
                .profession(member.getProfession())
                .signatureColor(member.getSignatureColor())
                .build();
    }
}
