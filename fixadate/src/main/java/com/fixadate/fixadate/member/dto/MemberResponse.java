package com.fixadate.fixadate.member.dto;

import com.fixadate.fixadate.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String name;
    private final String nickname;
    private final Integer birth;
    private final Boolean gender; //boolean to selection
    private final String profession;
    private final String signatureColor;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.birth = member.getBirth();
        this.gender = member.getGender();
        this.profession = member.getProfession();
        this.signatureColor = member.getSignatureColor();
    }
    @Builder
    public MemberResponse(Long id, String name, String nickname, Integer birth, Boolean gender, String profession, String signatureColor) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.profession = profession;
        this.signatureColor = signatureColor;
    }
}
